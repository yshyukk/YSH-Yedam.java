package com.yedam.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	// ORACLE DB에 대한 정보
	private String jdbcDriver;
	private String oracleUrl;
	private String connectedId;
	private String connectedPwd;
	// 공통으로 사용되는 필드

	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	// 한번만 실행시키고자 한다면 생성자 안에서 생성해도 됨
	public DAO() {
		dbConfig();
	}

	// DAO에는 DB접속,해제 메서드만 있는게 정석
	// DB접속 메서드
	public void connect() {
		try {
			Class.forName(jdbcDriver);

			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");

		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}

	}

	// DB정보 가져오는 메서드

	private void dbConfig() {

		String resource = "config/db.properties";
		Properties properties = new Properties();
		// Properties로 값을 읽으면 키와 벨유의 틀만 있으면 구분가능
		// filePath는 properties의 경로를 정확하게 찾기 위해서
		// getResource는 지정한 파일을 찾는 것
		// catch 구문안에는 절대 비워두지 않기
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}

	// DB해제 메서드
	public void disConnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
