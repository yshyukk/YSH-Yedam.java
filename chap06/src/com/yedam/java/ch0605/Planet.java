package com.yedam.java.ch0605;

public class Planet {
	// 필드
	final int radius;
	static final double pi = 3.1459;	// static = 누구나 볼수 있는, final = 고정
	
	//생성자
	Planet(int radius){
		this.radius = radius; // <-- 생성자를 생성할때 초기화 함.
	}
	//메서드
	void getArea() {
		double result = 4 * Planet.pi * this.radius;
		System.out.println("행성의 표먼적 : " + result);
	}
}
