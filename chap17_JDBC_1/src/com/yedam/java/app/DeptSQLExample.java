package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSQLExample {

	public static void main(String[] args) {
		try {
			// 1. JDBC Driver 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB 서버 접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pwd = "hr";

			Connection conn = DriverManager.getConnection(url,id,pwd);
			// 3. CRUD 실행
			/************ INSERT **************/
			// 1) PreparedStatement 객체 생성
			String insert = "INSERT INTO departments VALUES(?, ?, null, null)";
			PreparedStatement pstmt = conn.prepareStatement(insert);
			// 2) Query 구성
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "YEDAM");
//			pstmt.setInt(3, 100);
//			pstmt.setInt(4, 2500);
			// 3) 실행 후 결과 출력
			int result = pstmt.executeUpdate();

			System.out.println("insert 실행 : " + result);

			/************ UPDATE **************/
			// 1) PreparedStatement 객체 생성
			String update = "UPDATE departments SET department_name = ? WHERE department_id=? ";
			pstmt = conn.prepareStatement(update);

			// 2) Query 구성
			pstmt.setString(1, "JAVA");
			pstmt.setInt(2, 1000);
			// 3) 실행 후 결과 출력
			result = pstmt.executeUpdate();
			System.out.println("update 결과 : " + result);

			/************ SELECT **************/
			// 1) PreparedStatement 객체 생성
			String select = "SELECT * FROM departments ORDER BY department_id";
			// 2) Query 구성
			pstmt = conn.prepareStatement(select);
			ResultSet rs = pstmt.executeQuery();

			// 3) 실행 후 결과 출력
			while (rs.next()) {
				String info = "부서 번호 : " + rs.getInt("department_id") + ", 부서이름 : " + rs.getString("department_name");
			}
			/************ DELETE **************/
			// 1) PreparedStatement 객체 생성
			String delete = "DELETE FROM departments WHERE department_id=?";
			pstmt = conn.prepareStatement(delete);
			// 2) Query 구성
			pstmt.setInt(1, 1000);
			result = pstmt.executeUpdate();
			// 3) 실행 후 결과 출력
			System.out.println("DELETE 결과 : " + result);
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("DB 서버 접속 실패");

		} catch (SQLException s) {
			System.out.println("Query 실행 실패");
			s.printStackTrace();
		}
		// 4. 자원해제

	}
}
