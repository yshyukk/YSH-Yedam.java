package com.yedam.java.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

// 단순히 등록만 하는 기능
public class ProductDAO extends DAO {
	// 싱글톤
	private static ProductDAO productDAO = new ProductDAO();

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		if (productDAO != null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	// CRUD
	// 등록
	// (Product product) : 통째로 정보를 가져와야하니까
	public void insert(Product product) {
		try {
			connect();
			// (prodcut_seq.nextval, ?, ?) -> id 들어갈 부분에 DB에 sequence를 넣어줌.
			// prodcut_seq.nextval : 자동으로 제품번호가 추가됨
			// SQL문 해석하면 제품번호는 자동으로 추가되고 나머지부분만 내가 직접 추가한다는 느낌.
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 무엇을 수정할지 (가격)
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price =? WHERE product_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
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
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("삭제되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 제품번호
	public Product selectOne(int ProductId) {
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id = " + ProductId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return pro;
	}

	// 단건조회 - 제품이름
	public Product selectOne(String ProductName) {
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name = '" + ProductName +"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return pro;
	}
	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));

				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}
}
