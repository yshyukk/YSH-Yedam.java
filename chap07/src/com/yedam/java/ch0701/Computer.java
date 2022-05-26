package com.yedam.java.ch0701;

public class Computer extends Calculator {
	//동일한 기능에 대해 덮어쓸때 메서드 재정의
	
	@Override	//<-- 자바에게 알려줌
	double areaCircle(double r) { //메서드 재정의 할때 내용만 재정의 , 시그니처는 건드리지 말고
		
		System.out.println("computer 객체");
		return Math.PI*r*r;	
	}
	void print() {
		super.areaCircle(5);
		areaCircle(5);
	}
}
