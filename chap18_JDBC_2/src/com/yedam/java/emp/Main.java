package com.yedam.java.emp;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//EmpDAO는 싱글톤이므로 안에 메서드를 쓰기위해서 getInstace().method()로 사용
		Employee list = EmpDAO.getInstance().selectOne(100);

		System.out.println(list);
		
	}

}
