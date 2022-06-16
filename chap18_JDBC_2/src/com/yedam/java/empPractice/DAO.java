package com.yedam.java.empPractice;

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

import com.yedam.java.emp.Employee;

public class DAO {

	private static DAO dao = null;

	private DAO() {
	}

	public static DAO getInstance() {
		if (dao == null) {
			dao = new DAO();
		}
		return dao;

	}

	String jdbc_driver;
	String oracle_url;
	String id;
	String connectedId;
	String connectedPwd;

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		dbConfig();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Drvier 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB접속 실패");
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
	//CRUD 실행
		//전체조회
	public List<Departments> selectAll() {
		List<Departments> list = new ArrayList<>();

		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM DEPARTMENTS");

			while (rs.next()) {
				Departments dep = new Departments();

				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));

				list.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
		//단건조회
	public Departments selectOne(int departmentId) {
		// 단건조회 할때는 null로 초기화
		// 데이터가 없으면 null로 출력되기 때문에
		Departments dep = null;
		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id =" + departmentId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 반환 하는 값이 하나만 와야 되므로 While문 말고 If문으로
			if (rs.next()) {
				dep = new Departments();

				dep.setDepartmentId(rs.getInt("department_Id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dep;

	}
		//등록
	public void insert(Departments dep) {
		try {
			connect();
			String sql = "INSERT INTO departments VALUE (?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dep.getdepartmentId());
			pstmt.setString(2, dep.getDepartmentName());
			pstmt.setInt(3, dep.getManagerId());
			pstmt.setInt(4, dep.getLocationId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
		//수정
	public void update(Departments dep) {
		try {
			connect();
			String sql = "UPDATE departments SET department_name =? WHERE department_id=?";
			pstmt = conn.prepareStatement(sql);
			// 칼럼 위치, 칼럼의 값
			pstmt.setInt(2, dep.getdepartmentId());
			pstmt.setString(1, dep.getDepartmentName());

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
	//삭제
	public void delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departments WHERE department_id=";
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
