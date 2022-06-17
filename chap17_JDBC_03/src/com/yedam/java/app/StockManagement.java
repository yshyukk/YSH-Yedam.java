package com.yedam.java.app;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.histoyty.History;
import com.yedam.app.histoyty.HistoryDAO;
import com.yedam.java.app.product.Product;
import com.yedam.java.app.product.ProductDAO;

import common.Info;

//재고관리 시스템
public class StockManagement {
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDao = ProductDAO.getInstance();
	private HistoryDAO hDao = HistoryDAO.getInstance();

	public StockManagement() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 제품등록
				inPutProdcut();
			} else if (menuNo == 2) {
				// 제품입고
				prodcutIn();
			} else if (menuNo == 3) {
				// 제품출고
				productOut();
			} else if (menuNo == 4) {
				// 제품재고
				productStock();
			} else if (menuNo == 5) {
				// 전체재고
				allProductStock();
			} else if (menuNo == 9) {
				// 종료
				exit();
			} else {
				showInfoError();
			}
		}
	}

	private void menuPrint() {
		System.out.println("=====================================================");
		System.out.println("1.제품등록 | 2.입고 | 3.출고 | 4.제품재고 | 5.전체재고 | 9.종료");
		System.out.println("=====================================================");

	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menu;
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void showInfoError() {
		System.out.println("메뉴를 참고하여 입력해주시기 바랍니다.");
	}

	private void inPutProdcut() {
		// 제품정보 입력 받고
		Product product = inputAll();
		// DB에 저장
		pDao.insert(product);
	}

	private void prodcutIn() {
		// 입고할 제품과 수량 입력

		Info info = infoAmount();
		// 기존에 등록되어 있는 제품인지를 확인
		System.out.println(info.getProductAmount());
		System.out.println(info.getProductName());
		Product product = pDao.selectOne(info.getProductName());
		if (product != null) {
			// -1 기존에 등록된 제품일 경우 입고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());

			hDao.insert(history);
		} else {
			// -2 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품 정보를 우선 등록해주세요.");
		}
	}

	private void productOut() {
		// 출고할 제품과 수량을 입력받고
		Info info = infoAmount();
		// 등록되어있는 제품인지 확인하구여
		// 사람은 이름을 기억하지요
		Product product = pDao.selectOne(info.getProductName());
		// 재고량이 있는지 확인해야대여
		// -1 등록되어 있는지부터 확인!
		if (product == null) {
			System.out.println("제품부터 등록하세여");
			return;
		}
		// -2 재고량이 있는지 확인
		int stock = selectStock(product.getProductId());
		// 재고량과 출고량을 비교할껍니다
		if (stock >= info.getProductAmount()) {
			// -1 위 조건을 모두 만족하는 경우 출고처리할꺼구요
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(2);
			history.setProductAmount(info.getProductAmount());

			hDao.insert(history);

		} else {
			// -2 각 조건이 만족하지 않는 경우 적합한 문구를 출력해야겠죠
			System.out.println("재고량이 출고량보다 작습니다.");
		}
	}

	private void productStock() {
		// 검색하고자 하는 제품 정보 입력
		String productName = inputName();
		// 등록된 제품인지 확인
		Product product = pDao.selectOne(productName);

		if (product == null) {
			System.out.println("해당 제품의 정보가 등록되어있지 않습니다.");
			return;
		}
		// 해당 제품의 재고 출력
		int stock = selectStock(product.getProductId());

		System.out.println("|| 제품번호 : " + product.getProductId() + " | 제품이름 : " + product.getProductName() + " | 재고 : "
				+ stock + " ||");

	}

	private void allProductStock() {
		Map<Integer, Integer> list = hDao.SelectAllAmount();
		Set<Integer> productList = list.keySet();
		for (int productId : productList) {
			Product product = pDao.selectOne(productId);
			int stock = list.get(productId);
			System.out.println("|| 제품번호 : " + product.getProductId() + " | 제품이름 : " + product.getProductName()
					+ " | 재고 : " + stock + " ||");

		}
	}

	private Product inputAll() {
		// 모든 정보를 가져오는건 아니고 제품이름과 가격만
		Product product = new Product();
		System.out.println("제품이름 > ");
		product.setProductName(sc.nextLine());
		System.out.println("제품가격 > ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;

	}

	private Info infoAmount() {
		Info info = new Info();
		System.out.println("제품이름 > ");
		info.setProductName(sc.nextLine());
		System.out.println("제품수량 > ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}

	private String inputName() {
		System.out.println("제품이름>");
		return sc.nextLine();
	}

	private int selectStock(int productId) {

		// 입고량과 출고량 가져오기
		int in = hDao.SelectInAmount(productId);
		int out = hDao.SelectOutAmount(productId);

		return (in - out);
	}
}
