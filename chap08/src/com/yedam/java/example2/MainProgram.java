package com.yedam.java.example2;

import java.util.Scanner;

public class MainProgram {
	// 필드
	private Scanner sc = new Scanner(System.in);
	private Access dao = StudentRepo.getInstance(); // 저장소
	private Program program = new StudentProgram(); // 프로그램

	// 생성자
	public MainProgram() {
		while (true) {
			program.menuPrint();
			int menuNo = menuSelect();
			
			if (menuNo == 1) {
				program.inputInfo(dao);
			} else if (menuNo == 2) {
				program.printAll(dao);
			} else if (menuNo == 3) {
				program.printInfo(dao);
			} else if (menuNo == 4) {
				program.printRepot(dao);
			} else if (menuNo == 5) {
				exit();
				break;
			}
		}

	}
	// 메서드

	private int menuSelect() {
		System.out.println("선택>");
		return Integer.parseInt(sc.nextLine());
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
}
