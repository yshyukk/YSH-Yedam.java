package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class TakeOutGoodsDAO extends DAO{

	private static TakeOutGoodsDAO dao =null;
	
	private TakeOutGoodsDAO() {
		
	}
	public static TakeOutGoodsDAO getInstance() {
		if (dao == null) {
			dao = new TakeOutGoodsDAO();
		}
		return dao;
	}
	//등록
	public void insert(DealInfo info) {
		
		try {
			connect();
			String sql = "INSERT INTO take_out_goods "
					+ " (product_id, product_amount) "
					+ " VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	//단건조회 -출고량
	public boolean selectoutInfo(int productId) {
		boolean isSelected = false;
		// 1. 출고내역 존재 유무
		try {
			connect();
			String sql = "SELECT COUNT(*) AS count FROM take_out_goods WHERE porduct_id = " + productId;
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
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount),0) as sum FROM take_out_goods WHERE product_id = "
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

	
	//전체조회
	// 1.현재까지 출고된 내역(전체 출고내역)
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<>();

		try {
			connect();
			String sql = "SELECT t.deal_date, p.product_id, p.product_name, t.product_amount "
					+ " FROM products p"
					+ " JOIN take_out_goods t ON p.product_id = t.product_id" 
					+ " ORDER BY t.deal_date";
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
	// 2. 해당 날짜에 출고된 내역
		public List<DealInfo> selectAll(Date dealDate) {
			List<DealInfo> list = new ArrayList<>();

			try {
				connect();
				String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount + FROM products p"
						+ " JOIN take_out_goods t ON p.product_id = t.product_id" + " WHERE deal_date = ?"
						+ " ORDER BY t.deal_date";
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
		// 3. 해당 제품에 출고된 내역
		public List<DealInfo> selectAll(int productId) {
			List<DealInfo> list = new ArrayList<>();

			try {
				connect();
				String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount + FROM products p"
						+ " JOIN take_out_goods t ON p.product_id = t.product_id" + " WHERE product_id = ?"
						+ " ORDER BY t.deal_date";
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
