package com.yedam.app.deal;

import java.sql.SQLException;

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
			String sql = "INSERT INTO take_out_goods + (product_id, product_amount) + VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2,info.getProductAmount());
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	//단건조회
	
	//전체조회
	
	
	
}
