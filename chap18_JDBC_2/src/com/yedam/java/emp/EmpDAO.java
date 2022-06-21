package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// DAO : DB에 있는 정보를 전달만. (여기서 연산은 X)
// DAO는 가능한 싱글톤으로
public class EmpDAO {

	private static EmpDAO empDAO = null;

	private EmpDAO() {
	}

	// null일때만 생성자 호출
	public static EmpDAO getInstance() {
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;

	}

	// Oracle 연결 정보 (데이터에 연결할때 필요한 정보)
	String jdbc_driver;
	String oracle_url;
	String id;
	String connectedId;
	String connectedPwd;
	
	// 각 메서드에서 공통적으로 사용하는 필드
	// => 데이터베이스를 사용할 때 필요한 도구들

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	//위에서 정의한 도구들을 이용해 연결.
	public void connect() {
		dbConfig();
		try {
			// 1. JDBC Driver 로딩
			Class.forName(jdbc_driver);
			// 2. DB 서버 접속
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Drvier 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		// Properties로 값을 읽으면 키와 벨유의 틀만 있으면 구분가능
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}

	// 4. 자원 해제
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// 3. CRUD 실행
	// 전체조회
	// 몇개가 들어올지 알 수 없기때문에 배열X
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();

		// 이 try catch문은 거의 고정적으로 사용됨.
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees");

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstname(rs.getString("first_name"));
				emp.setLastname(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommission(rs.getDouble("commission_pct"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	// 매개변수안에 들어가는 값은 기본키값
	public Employee selectOne(int employeeId) {
		// 단건조회 할때는 null로 초기화
		// 데이터가 없으면 null로 출력되기 때문에
		Employee emp = null;
		try {
			connect();
			String sql = "SELECT * FROM employees WHERE employee_id =" + employeeId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 반환 하는 값이 하나만 와야 되므로 While문 말고 If문으로
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstname(rs.getString("first_name"));
				emp.setLastname(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommission(rs.getDouble("commission_pct"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;

	}

	// 등록
	public void insert(Employee emp) {
		try {
			connect();
			String sql = "INSERT INTO employees VALUE (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstname());
			pstmt.setString(3, emp.getLastname());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommission());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void update(Employee emp) {
		try {
			connect();
			String sql = "UPDATE employees SET salary =? WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			// 칼럼 위치, 칼럼의 값
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건이 수정되었습니다");
			} else {
				System.out.println("수정되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}

	}

	// 삭제
	public void delete(int employeeId) {
		try {
			connect();
			String sql = "DELETE FROM employees WHERE employee_id=";
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");

			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}