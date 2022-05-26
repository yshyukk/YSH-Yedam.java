package com.yedam.java.ch0701;

public class CoumputerTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();	// <-- 인스턴스 생성
		
		System.out.println("원 면적 : " + cal.areaCircle(10));
		
		Computer com = new Computer();
		System.out.println("원 면적 : " + com.areaCircle(10));

		System.out.println();
		
		com.print();
	}
}

// 우선순위는 자식