package com.yedam.java.ch0901;

public class Z {
	//인스턴스 멤버 = Z 클래스의 인스턴스가 존재. B,C클래스 사용 가능.
	B filed1 = new B(); //B클래스는 Z클래스의 인스턴스가 존재해야 함
	C filed2 = new C(); //C클래스는 Z클래스의 정보만 있으면 됨
	
	//외부클래스 입장에서는 C클래스가 정적클래스라도 상관없이 사용 가능 = 정적필드나 메서드를 생성자로 사용할 수 있음.
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	//정적 멤버 = Z클래스의 인스턴스가 없을 수 있다.
	static B filed3 = new B();	// 반드시 Z클래스의 인스턴스가 필요, 정적멤버는 인스턴스를 보장하지 않음.
	static C filed4 = new C();	// Z클래스의 정보만 필요, Z클래스가 선언은 돼 있음.
	
	static void method2() {
		B var1 = new B();
		C var2 = new C();
	}
	
	//인스턴스 멤버 클래스
	class B {}
	//정적 멤버 클래스
	static class C {}
	
	
	
}
