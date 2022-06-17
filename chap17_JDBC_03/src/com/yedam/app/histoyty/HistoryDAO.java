package com.yedam.app.histoyty;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.java.app.common.DAO;

//싱글톤
public class HistoryDAO extends DAO {

	private static HistoryDAO historyDAO = null;

	private HistoryDAO() {
	}

	// getInstance는 외부에서 호출해야 하니까 public.
	public static HistoryDAO getInstance() {
		if (historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}

	// CRUD

	// 등록
	public void insert(History his) {

		try {
			connect();
			String sql = "SELECT INTO history Value (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, his.getProductId());
			pstmt.setInt(3, his.getProductAmount());
			pstmt.setInt(2, his.getProductCategory());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 수량
	public void update(History his) {

		try {
			connect();
			String sql = "UPDATE history SET product_amount WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, his.getProductId());
			pstmt.setInt(1, his.getProductAmount());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건이 수정되었습니다.");
			} else {
				System.out.println("수정이 되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제

	// 단건조회 - 각 상품에 대한 입고량
	public int SelectInAmount(int productId) {
		// return값이 있을때는 항상 변수 초기화부터
		int result = 0;

		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id=? AND product_category = 1";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// sql문에서 별칭으로 불러와도 됨.
				result = rs.getInt("sum");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 단건조회 - 각 상품에 대한 출고량

	public int SelectOutAmount(int productId) {
		// return값이 있을때는 항상 변수 초기화부터
		int result = 0;
		// sql문에서 카테고리를 1=입고, 2=출고로 하기로 했으니까
		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id=? AND product_category =2";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, productId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// sql문에서 별칭으로 불러와도 됨.
				result = rs.getInt("sum");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	public Map SelectAllAmount() {
		Map<Integer, Integer> list = new HashMap<>();
		// 데이터 가져와서 자바에서 연산
		// 제품이름이 지정되어 있어서 Map으로
		// Class를 이용하면 내부에 필드를 검색하는데 생각보다 어렵기 때문에

		try {
			connect();
			// DB에서 각 입고량과 출고량을 일단 가져옴
			String sql = "SELECT product_id, product_category, SUM(product_amount) as amount FROM product_history GROUP BY product_id,product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 입고와 출고에 따른 각각의 목록
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			while (rs.next()) {
				int category = rs.getInt("product_category");

				if (category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("amount"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}
			}
			// 입고량과 출고량을 이용해서 재고를 구함.
			Set<Integer> KeySet = inList.keySet();
			for (int key : KeySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(KeySet);
				if (outAmount != null) {
					list.put(key, (inAmount - outAmount));
				} else {
					list.put(key, inAmount);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

}
