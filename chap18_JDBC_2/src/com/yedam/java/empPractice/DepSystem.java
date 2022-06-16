package com.yedam.java.empPractice;

import java.util.List;
import java.util.Scanner;

public class DepSystem {

	private DAO dao = DAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	public DepSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 등록
				insertDepartments();
			} else if (menuNo == 2) {
				// 수정
				updateDepartments();
			} else if (menuNo == 3) {
				// 삭제
				deleteDepartments();
			} else if (menuNo == 4) {
				// 사원조회(단건)
				selectDepartments();
			} else if (menuNo == 5) {
				// 전체조회
				selectAllDepartments();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				inputError();
			}
		}
	}

	private void menuPrint() {
		System.out.println("==================================================");
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.부서조회 | 5.전체조회 | 9. 종료 ");
		System.out.println("==================================================");
	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");

		}
		return menu;
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");

	}

	private void inputError() {
		System.out.println("메뉴에 맞게 입력해주세요.");
	}

	private void insertDepartments() {

		Departments dep = inputAll();
		// DB에 전달
		dao.insert(dep);
	}

	private void updateDepartments() {
		// 수정하는 정보 입력받고
		Departments dep = inputUpdateInfo();
		// DB에 전달
		dao.update(dep);
	}

	private void deleteDepartments() {
		// 부서번호 입력
		int departmentId = inputDepartmentId();
		// DB에 전달
		dao.delete(departmentId);

	}

	private void selectDepartments() {
		// 사원번호 입력
	
		// DB검색
		Departments dep = dao.selectOne(inputDepartmentId());
		// 결과 출력
		// emp가 null = 입력한 사원정보가 없다.
		if (dep != null) {
			System.out.println(dep);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private void selectAllDepartments() {
		List<Departments> list = dao.selectAll();
		for (Departments dep : list) {
			System.out.println(dep);
		}
	}

	private Departments inputAll() {
		Departments dep = new Departments();
		// Integer.parseInt(sc.nextInt()) : 내가 입력하는 값을 Int로 받는다
		// Integer.parseInt(sc.nextLine()) : 내가 입력하는 값을 String으로 받는다
		// ==> 내가 입력하는 값을 바꾸는 것.
		// Int와 Line의 차이 : Int는 공백기준으로 자르고, Line은 Enter기준으로 자른다.
		System.out.println("부서번호>>");
		dep.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서이름>>");
		dep.setDepartmentName(sc.nextLine());
		System.out.println("상사>>");
		dep.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.println("근무지 지역정보>>");
		dep.setLocationId(Integer.parseInt(sc.nextLine()));

		return dep;
	}

	private Departments inputUpdateInfo() {
		Departments dep = new Departments();
		System.out.println("부서번호");
		dep.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서이름");
		dep.setDepartmentName(sc.nextLine());

		return dep;
	}

	private int inputDepartmentId() {
		System.out.println("부서번호");
		return Integer.parseInt(sc.nextLine());
	}
}
