package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.members.Member;
import com.yedam.app.members.MembersDAO;
import com.yedam.app.product.Management;

public class LoginControl {
	Scanner sc = new Scanner(System.in);
	//로그인 정보를 저장하는
	private static Member loginInfo = null;

	//한번 로그인을 로그인 하는동안 로그인을 유지해야함
	public static Member getLoginInfo() {
		return loginInfo;
	}
	
	public LoginControl() {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
			//로그인	
				login();
			}else if(menuNo == 2 ) {
			//종료
				exit();
				break;
			}else {
				showInputError();
			}
		}
	}
	private void menuPrint() {
		System.out.println("===================");
		System.out.println("||1.로그인 | 2.종료 ||");
		System.out.println("===================");
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자 형식으로 ㅇ비력해주세요");;
		}
		return menuNo;
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void showInputError() {
		System.out.println("메뉴를 확인해주시기 바랍니다.");
	}
	
	private void login() {
		//아이디와 비밀번호 입력
		Member inputinfo = inputMember();
		//로그인 시도
		loginInfo = MembersDAO.getInstance().selectOne(inputinfo);
		
		//실패할 경우에는 그대로 메소드 종료
		if(loginInfo == null) return;
		//성공할 경우 프로그램을 실행
		new Management().run();
	}
	
	private Member inputMember() {
		Member info = new Member();
		System.out.println("아이디 > ");
		info.setMemberId(sc.nextLine());
		System.out.println("비밀번호 > ");
		info.setMemberPassword(sc.nextLine());
		return info;
	}
}
