package com.yedam.java.example1;

import java.util.Scanner;

public class CustomerSystem {	//실제로 실행되는 클래스
	//필드
	private Repo repo = new Repo();//기억해둬야할 DB 저장소 생성
	private Scanner sc = new Scanner(System.in);
	//생성자
	public CustomerSystem() {
		while(true) { 
			//메뉴 출력
			menuPrint();
			
			//메뉴 선택
			int menuNo = menuSelect();
			
			if(menuNo == 1) {//메뉴 1 - 회원가입//<--- 스위치 사용X, if문 사용
			signUp();	
			}else if(menuNo ==2) {//메뉴 2 - 회원정보
			myPage();	
			}else if(menuNo ==3) {
			payInfo();	
			}else if(menuNo ==4) {
			exit();
			break;
			}
			//메뉴 2	- 회원정보조회
			//메뉴 3 - 결제시 금액
			
		}
	}
	//메소드
	void menuPrint() {	//메뉴출력 메서드
		System.out.println("=======================================");
		System.out.println("1. 회원가입 | 2.회원정보 | 3.결제금액 | 4. 종료");
		System.out.println("=======================================");
		
	}
	int menuSelect() {	//메뉴선택
		System.out.println("메뉴 >");
		return Integer.parseInt(sc.nextLine());
	}
	void signUp() {	//두가지 기능 1. 등급선택 2.회원정보 입력
		//등급 선택
		
		//회원정보 입력
		Customer info = inputAll();
		//가입
		repo.insert(info);
	}
	Customer inputAll() {	//회원정보를 입력받는 곳
		//회원 기본 정보 입력
		
		System.out.println("ID > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("이름 > ");
		String name = sc.nextLine();
		
		// 회원 등급 선택
		
		/*Customer customer = getGrade();
		customer.setCustomerId(id);
		customer.setCustomerName(name);
		*/
		
		int selcetd = selectGrade();
		Customer customer = null; 
		switch(selcetd) {
		
		case 1:
			customer = new Customer(id, name);
			break;
		case 2:	
			customer = new Gold(id, name);
			break;
		case 3:
			customer = new Vip(id,name, "asdzwd");
			break;
		}
		return customer;
	}
	
	int selectGrade() {
		System.out.println("1.SILVER | 2.GOLD | 3. VIP");
		System.out.println("---------------------------");
		return Integer.parseInt(sc.nextLine());
		
	}
	void myPage() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		System.out.println(info.showInfo());
		}
	void payInfo() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		
		System.out.println("구매 금액 > ");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calPrice(price);
		System.out.println("결제 금액 > " + pay);
	}
	void exit() {
		System.out.println("프로그램 종료");
		
	}
	int inputOne() {
		System.out.println("고객 아이디 > ");
		return Integer.parseInt(sc.nextLine());
	}
}

