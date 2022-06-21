package com.yedam.app.product;

import java.util.Scanner;

import com.yedam.app.deal.RecivingGoodsDAO;

public class Management {
	// 필드
	protected Scanner sc = new Scanner(System.in);
	protected ProductsDAO pDAO = ProductsDAO.getInstance();
	protected RecivingGoodsDAO rDAO = RecivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();

	// 생성자 -> run
	public void run() {
		//생성자에서 while문 사용하는 이유??
		// 생성자가 인스턴스생성하니까 다른 클래스에서 이 클래스의 인스턴스를 사용하면 생성자안에 while문이 실행된다는 건가?
		//생성자가 종료될때까지 계속 반복
		//ProductInfoManagement();가 실행될때 while문 종료가 안됨 => 생성자를 이용해서 사용 불가능
		//그래서 run이라는 메서드로 사용 => 내가 실행시키고자 하는 메서드를 감싸는 역할만
		
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품정보관리
				new ProductInfoManagement();
			} else if (menuNo == 2) {
				// 제품관리
				new ProductStockManagement();
			} else if (menuNo == 9) {
				// 프로그램 종료
				exit();
				break;
			} else {
				// 입력오류
				showInputError();
			}
		}
	}

	// 메소드
	protected void menuPrint() {
		System.out.println("===============================");
		System.out.println("1. 제품정보관리 | 2. 제품관리 | 3. 종료");
		System.out.println("===============================");
	}

	protected int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());

		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}
		return menuNo;
	}

	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	protected void showInputError() {
		System.out.println("메뉴에서 입력해주시기 바랍니다.");
	}
}
