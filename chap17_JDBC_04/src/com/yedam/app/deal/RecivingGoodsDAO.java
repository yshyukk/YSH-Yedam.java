package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class RecivingGoodsDAO extends DAO {

	// 싱글톤
	private static RecivingGoodsDAO dao = null;

	private RecivingGoodsDAO() {
	}

	public static RecivingGoodsDAO getInstance() {
		if (dao == null) {
			dao = new RecivingGoodsDAO();
		}
		return dao;
	}

	// 기본키가 없기 때문에 수정,삭제 불가능
	// 등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO receiving_goods + (product_id, product_amount) + VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 단건조회
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		// 1. 입고내역 존재 유무
		try {
			connect();
			String sql = "SELECT COUNT(*) AS count FROM receiving_goods WHERE porduct_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				if (rs.getInt("conut") > 0) {
					isSelected = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return isSelected;
	}

	// 2. 입고수량 확인
	public int selecAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount),0) as sum FROM receiving_goods WHERE product_id = "
					+ productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				amount = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return amount;
	}

	// 전체조회
	// 1. 현재까지 입고된 내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<>();

		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, r.product_name, r.product_amount + FROM products p"
					+ " JOIN receiving_goods r ON p.product_id = r.product_id" + " ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 2. 해당 날짜에 입고된 내역
	public List<DealInfo> selectAll(Date dealDate) {
		List<DealInfo> list = new ArrayList<>();

		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, r.product_name, r.product_amount + FROM products p"
					+ " JOIN receiving_goods r ON p.product_id = r.product_id" + " WHERE deal_date = ?"
					+ " ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 3. 해당 제품에 입고된 내역
	public List<DealInfo> selectAll(int productId) {
		List<DealInfo> list = new ArrayList<>();

		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, r.product_name, r.product_amount + FROM products p"
					+ " JOIN receiving_goods r ON p.product_id = r.product_id" + " WHERE product_id = ?"
					+ " ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));

				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
}
