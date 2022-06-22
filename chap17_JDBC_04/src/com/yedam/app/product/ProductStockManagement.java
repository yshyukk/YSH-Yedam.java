package com.yedam.app.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.app.deal.DealInfo;
import com.yedam.app.deal.RecivingGoodsDAO;
import com.yedam.app.deal.TakeOutGoodsDAO;

public class ProductStockManagement extends Management {
	// 제품 입고, 출고, 재고를 관리하는 프로그램
	private Scanner sc = new Scanner(System.in);
	private RecivingGoodsDAO rDAO = RecivingGoodsDAO.getInstance();
	private TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();

	public ProductStockManagement() {
		boolean role = selectRole();

		while (true) {
			menuPrint(role);
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1 && role) {
				// 입고정보 등록(제품입고)
				productIn();
			} else if (menuNo == 2 && role) {
				// 출고정보 등록(제품출고)
				productOut();
			} else if (menuNo == 3) {
				// 재고조회
				productStock();
			} else if (menuNo == 4 && role) {
				// 제품거래내역
				productDeal();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				showInfoError();
			}

		}
	}

	// @Override // 앞의 menuPrint와 내용이 다르기 때문에 override
	protected void menuPrint(boolean role) {
		// null로 초기화 하면 null에 더해져서 출력되기때문에 빈공백으로
		String menu = "";
		if (role) {
			menu += "1.입고" + " 2.출고";
		}
		menu += " 3.재고";
		
		if (role) {
			menu += " 4.거래내역";
		}
		menu += " 9.뒤로가기";
		System.out.println("==========================================");
		System.out.println(menu);
//		System.out.println("1.입고 | 2.출고 | 3.재고 | 4.거래내역 | 9.뒤로가기");
		System.out.println("==========================================");

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

	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}

	private void showInfoError() {
		System.out.println("메뉴를 참고하여 입력해주시기 바랍니다.");
	}

	private void productIn() {
		// 제품과 입고수량을 입력받고
		// inputAmount() = 수량과 제품정보를 받아오는 메서드
		DealInfo info = inputAmount();
		// 해당제품의 등록여부
		Product product = pDAO.selectOne(info.getProductName());

		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 등록되었을 경우에 입고처리
		info.setProductId(product.getProductId());
		rDAO.insert(info);

		// 입고처리가 완료되었을 경우에 재고를 수정(Product_stock에 데이터를 Update)
		// => 제품정보 - 재고량을 수정
		updateProductStock(info.getProductId());
	}

	private void productOut() {
		// 제품이름과 출고수량을 입력
		DealInfo info = inputAmount();
		// 제품의 등록 여부
		Product product = pDAO.selectOne(info.getProductName());

		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 해당 제품의 재고와 출고수량을 비교
		if (product.getProductStock() < info.getProductAmount()) {
			System.out.println("재고가 부족합니다.");
			return;
		}
		// 재고보다 출고수량이 적을 경우 출고처리
		info.setProductId(product.getProductId());// info에는 productId없어서 product에서 받아오고
		tDAO.insert(info);
		// 제품의 재고량을 수정
		updateProductStock(info.getProductId());
	}

	private DealInfo inputAmount() {
		DealInfo info = new DealInfo();
		// 제품이름
		System.out.println("제품 이름 >");
		info.setProductName(sc.nextLine());

		// 수량
		System.out.println("수량 > ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));

		return info;
	}

	private void updateProductStock(int productId) {
		// 해당 제품의 재고량 확인 및 수정
		// 해당 제품의 입고량
		int inAmount = rDAO.selecAmount(productId);
		// 해당 제품의 출고량
		int outAmount = tDAO.selectAmount(productId);
		// 재고(입고량 - 출고량)을 수정
		int stock = inAmount - outAmount;

		Product product = new Product();
		product.setProductId(productId);
		product.setProductStock(stock);
		pDAO.updateStock(product);

	}

	private void productStock() {
		// 재고를 조회하고자 하는 제품이름 입력
		String productName = inputName();

		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;

		}
		// 해당 제품의 정보를 출력
		System.out.println(product);

	}

	private void productDeal() {
		// 입고인지 출고인지 선택
		int choice = inputSelect();

		List<DealInfo> list = new ArrayList<>();
		if (choice == 1) {
			list = rDAO.selectAll();
		} else if (choice == 2) {
			list = tDAO.selectAll();
		}

		for (DealInfo info : list) {
			System.out.println(info);
		}
	}

	private String inputName() {
		// 제품이름만 넘겨주기
		System.out.println("제품 이름 > ");
		return sc.nextLine();
	}

	private int inputSelect() {
		System.out.println("분류 : 1.입고 2.출고");
		int selected = Integer.parseInt(sc.nextLine());
		if (selected == 1) {
			System.out.println("=========입고내역");
		} else {
			System.out.println("=========출고내역");
		}
		return selected;
	}

}
