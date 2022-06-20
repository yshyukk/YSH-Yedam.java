package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductsDAO extends DAO {
	// 등록
	// VO객체로 넘겨받음
	public void insert(Product product) {
		// 항상 SQL문 사용할때는 try - catch - finally
		try {
			connect();
			String sql = "INSERT INTO products (product_id, product_name, product_price)"
					+ "VALUES (products_seq.nextval,? ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("등록완료!!!!!!!!!!!");
			} else {
				System.out.println("등록실패!!!!!!!!!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 수정 - 재고
	public void update(Product product) {
		// 항상 SQL문 사용할때는 try - catch - finally
		try {
			connect();
			String sql = "UPDATE products SET product_stock =" + product.getProductStock() + "WHERE product_id = "
					+ product.getProductId();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("수정완료!!!!!!!!!!!");
			} else {
				System.out.println("수정실패!!!!!!!!!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 삭제
	public void delete(int productId) {
		// 항상 SQL문 사용할때는 try - catch - finally
		try {
			connect();
			String sql = "DELETE FROM products WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				System.out.println("삭제완료!!!!!!!!!!!");
			} else {
				System.out.println("삭제실패!!!!!!!!!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 단건조회 -재고이름
	// 리턴타입을 class 단독으로
	// 매개변수는 조건이 되는것이 하나라면 변수를 사용하고 조건이 몇개 있으면 VO클래스를 이용해도 됨
	public Product selectOne(String productName) {
		// 변수 선언 후 리턴값 부터 선언해주기 (잘까먹으니까)
		// null값을 주는 이유?

		Product product = null;
		try {
			connect();
			// product_name은 primary Key가 아니라서 중복가능성 있음

			String sql = "SELECT * FROM products WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);

			rs = pstmt.executeQuery();

			// if문을 이용해서 값 가져오기
			// while문을 사용해도 한개의 값을 가져오기는 함 => list에 담는게 아니기 때문에 가져온 값을 계속 덮어쓰기 때문에
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return product;

	}

	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();

		try {
			connect();
			String sql = "SELECT * FROM products ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 전체 데이터가 몇개인지 확인할 수 없으니까 while문으로
			while (rs.next()) {
				// list에 담아질 변수먼저
				Product product = new Product();

				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));

				// add를 사용하지 않으면 값 자체가 출력되지 않아요
				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}
}
