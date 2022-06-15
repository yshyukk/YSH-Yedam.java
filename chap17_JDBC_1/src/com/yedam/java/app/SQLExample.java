package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 큰 순서 암기!
public class SQLExample {

	public static void main(String[] args) throws Exception {
		// << 1. JDBC Driver 로딩하기 >>
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// << 2. DB 서버 접속하기 >>
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";

		Connection con = DriverManager.getConnection(url, id, pwd);

		// << 3. CRUD 실행 >>
		// ****************** INSERT ************************//
			// 1) Statement or PrepareStatement 객체 생성하기
				// PrepareStatement : ?이용해서 변수처럼 사용 가능
				// 값을 넣고자 하는 곳에 ?만 넣으면 됨

		String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insert);

			// 2) SQL 구성 후 실행
				// set메서드를 이용해서 '?'를 대체. 즉, '?'에 들어갈 타입을 Set으로 정해주면 됨.
				// '?' 수만큼 set메서드를 작성해야 함.
				// SetInt(1, 1000) = ( 1번째 '?'를 대체한다., 1000으로)
				// 내가 넣고자 하는 타입에 맞게!
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "Kil-Dong");
		pstmt.setString(3, "Hong");
		pstmt.setString(4, "KdHong@google.com");
		pstmt.setString(5, "82.10.1234.1234");
		pstmt.setString(6, "21/11/05");
		pstmt.setString(7, "SA_REP");
		pstmt.setInt(8, 8600);
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10, 149);
		pstmt.setInt(11, 80);

			// 3) 결과 출력
				// insert, update, delete는 executeUpdate();
		int result = pstmt.executeUpdate();
		System.out.println("insert 실행결과 : " + result);

		// ****************** UPDATE ************************//
			// 1) Statement or PrepareStatement 객체 생성하기
				// 컬럼에는 '?'사용 X, 값으로 들어가는 곳에만 '?'
				// 컬렴명을 바꾸고 싶으면 Statement로
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
		pstmt = con.prepareStatement(update);
			// 2) SQL 구성 후 실행
		pstmt.setString(1, "Kang");
		pstmt.setInt(2, 1000);
			// 3) 결과 출력
		result = pstmt.executeUpdate();

		System.out.println("UPDATE 결과 : " + result);

		// ****************** SELECT ************************
			// 1) Statement or PrepareStatement 객체 생성하기
		String select = "SELECT * FROM employees ORDER BY employee_id";
		pstmt = con.prepareStatement(select);

			// 2) SQL 구성 후 실행
		ResultSet rs = pstmt.executeQuery();

			// 3) 결과 출력
		while (rs.next()) {
			String info = rs.getInt("employee_id") + " : " + rs.getString("first_name");
			System.out.println(info);
		}
		// ****************** DELETE ************************//
			// 1) Statement or PrepareStatement 객체 생성하기
		String delete = "DELETE FROM employees WHERE employee_id = ?";
		pstmt = con.prepareStatement(delete);

			// 2) SQL 구성 후 실행
		pstmt.setInt(1, 1000);

			// 3) 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("DELETE 결과 : " + result);
		
		// << 4. 자원 해제 >>
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();

		// unique가 나오면 기본키가 중복돼서 그럼 => Developer에 가서 직접 삭제해야함.
	}

}
