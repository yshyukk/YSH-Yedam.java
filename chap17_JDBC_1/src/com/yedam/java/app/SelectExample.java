package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC를 사용하는 가장 큰 골격, 가장 기본적인 방법!
// 이 패턴을 외워두기.

public class SelectExample {
	
	public static void main(String[] args) throws Exception {
		//1.JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. DB 서버 접속하기(인사관리)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id ="hr";
		String pwd = "hr";
		
		//getConnection
		
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		//3. Statement or PreparedStatement 객체 생성하기
			//ctrl+shift+o = 필요한거 추가해줌 (->import)
		Statement stmt = con.createStatement();
		
		//4. Query 구성
			//세미콜론은 X
		String sql = "SELECT * FROM employees WHERE last_name = 'King'";
		
		//5. Query 실행
			//ResultSet으로 executeQuery로 Query결과 저장
		ResultSet rs = stmt.executeQuery(sql);
		
		//6. 결과값 출력하기
			//총 크기를 알 수 없기 때문에 while문
			//next로 커서를 헹의 처음부터 끝까지 움직임.
			//get의 매개변수로 컬럼명 그대로.
		
		while(rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}
		//7. 자원해제하기
			// 생성된 순서의 반대로 해제
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
