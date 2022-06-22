package test_shy;

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

public class BookDAO {

	private static BookDAO bDAO = null;

	private BookDAO() {

	}

	public static BookDAO getInstace() {
		if (bDAO == null) {
			bDAO = new BookDAO();
		}
		return bDAO;
	}

	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

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
	//CRUD
	//등록
	public void insert(Book book) {
		
		try {
			connect();
			String sql = "INSERT INTO book VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			pstmt.setInt(4, book.getBookRental());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
				
			}else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}		
	}
	//수정
	public void update(Book book) {
		try {
			connect();
			String sql = "UPDATE product SET book_rental =? WHERE book_name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getBookRental());
			pstmt.setString(2, book.getBookName());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			}else {
				System.out.println("수정되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//삭제
	public void delete(String bookName) {
		try {
			connect();
			String sql = "DELETE FROM book WHERE book_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//단건조회
	public Book selectOne(String bookName) {
		
		
		Book book = null;
		try {
			connect();
			String sql = "SELECT * FROM book WHERE book_name = '" + bookName +"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getInt("book_rental"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return book;
	}
	
	//내용검색
	
	public List<Book> selectBookContent(String bookContent) {
		
		List<Book> list = new ArrayList<Book>();
		
		try {
			connect();
			String sql = "SELECT * FROM book WHERE book_content LIKE '%" + bookContent + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Book book = new Book();
				
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getInt("book_rental"));
				
				list.add(book);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return list;
	}
	
	//전체조회
	public List<Book> selectAll(){
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String sql = " SELECT * FROM book ORDER BY book_name";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getInt("book_rental"));
				
				list.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
}
