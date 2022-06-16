package com.yedam.java.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpSystem {
	private EmpDAO dao = EmpDAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	public EmpSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			// 메뉴
			if (menuNo == 1) {
				// 등록
				insertEmployee();
			} else if (menuNo == 2) {
				// 수정
				updateEmployee();
			} else if (menuNo == 3) {
				// 삭제
				deleteEmployee();
			} else if (menuNo == 4) {
				// 사원조회(단건)
				selectEmployee();
			} else if (menuNo == 5) {
				// 전체조회
				selectAllEmployee();
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
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.사원조회 | 5.전체조회 | 9. 종료 ");
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

	private void insertEmployee() {
		// 사원에 대한 정보를 입력 받아서
		Employee emp = inputAll();
		// DB에 전달
		dao.insert(emp);
	}

	private void updateEmployee() {
		// 수정하는 정보 입력받고
		Employee emp = inputUpdateInfo();
		// DB에 전달
		dao.update(emp);
	}

	private void deleteEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		// DB에 전달
		dao.delete(employeeId);

	}

	private void selectEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		// DB검색
		Employee emp = dao.selectOne(employeeId);
		// 결과 출력
		// emp가 null = 입력한 사원정보가 없다.
		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private void selectAllEmployee() {
		List<Employee> list = dao.selectAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

	// intput관련 메서드
	private Employee inputAll() {
		Employee emp = new Employee();
		//Integer.parseInt(sc.nextInt()) : 내가 입력하는 값을 Int로 받는다 
		//Integer.parseInt(sc.nextLine()) : 내가 입력하는 값을 String으로 받는다
		//==> 내가 입력하는 값을 바꾸는 것.
		// Int와 Line의 차이 : Int는 공백기준으로 자르고, Line은 Enter기준으로 자른다.
		System.out.println("사번>>");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.println("이름>>");
		emp.setFirstname(sc.nextLine());
		System.out.println("성>>");
		emp.setLastname(sc.nextLine());
		System.out.println("이메일>>");
		emp.setEmail(sc.nextLine());
		System.out.println("전화번호>>");
		emp.setPhoneNumber(sc.nextLine());
		System.out.println("입사일(YYYY-MM-DD)>>");
		emp.setHireDate(Date.valueOf(sc.nextLine()));
		System.out.println("직급>>");
		emp.setJobId(sc.nextLine());
		System.out.println("연봉>>");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		System.out.println("상여>>");
		emp.setCommission(Double.parseDouble(sc.nextLine()));
		System.out.println("상사>>");
		emp.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서>>");
		emp.setDepartmentId(Integer.parseInt(sc.nextLine()));

		return emp;
	}

	private Employee inputUpdateInfo() {
		Employee emp = new Employee();
		System.out.println("사번>>");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.println("연봉>>");
		emp.setSalary(Double.parseDouble(sc.nextLine()));

		return emp;

	}

	private int inputEmployeeId() {
		System.out.println("사번");
		return Integer.parseInt(sc.nextLine());
	}
}
