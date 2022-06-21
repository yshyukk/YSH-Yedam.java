package com.yedam.app.product;

import java.util.Scanner;

import com.yedam.app.deal.DealInfo;
import com.yedam.app.deal.RecivingGoodsDAO;
import com.yedam.app.deal.TakeOutGoodsDAO;

public class ProductStockManagement {
	
	private Scanner sc = new Scanner(System.in);
	private RecivingGoodsDAO rDAO = RecivingGoodsDAO.getInstance();
	private TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();
	
	public ProductStockManagement() {
		while(true) {
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 입고정보 등록
				inPutRecProdcut();
			} else if (menuNo == 2) {
				// 출고정보 등록
				prodcutToIn();
			} else if (menuNo == 3) {
				// 재고량 단건조회
				productOut();
			} else if (menuNo == 4) {
				// 재고량 전체조회
				productStock();
			}  else if (menuNo == 9) {
				// 종료
				exit();
			} else {
				showInfoError();
			}
			
		}
	}
	private void menuPrint() {
		System.out.println("==========================================================================");
		System.out.println("1.입고제품 정보등록 | 2.출고제품 정보등록 | 3.단건 재고조회 | 4.전체 재고조회 | 9.뒤로가기");
		System.out.println("==========================================================================");
		
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
	
	private void inPutRecProdcut() {
	
		DealInfo Info = infoAmount();
		System.out.println(Info.getProductAmount());
		System.out.println(Info.getProductName());
		DealInfo info = rDAO.insert(Info);
	}
}
