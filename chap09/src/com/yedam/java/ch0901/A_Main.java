package com.yedam.java.ch0901;

public class A_Main {

	public static void main(String[] args) {

		A a = new A(); // B클래스를 사용하기위해 A클래스를 먼저 생성

		System.out.println();

		A.B b = a.new B(); // 인스턴스 변수 이름에 접근해서 B클래스 생성자를 호출.
		b.feild1 = 1;
		b.method1();

		A.C.fiedl2 = 2; // C클래스는 정적 클래스라서 바로 호출도 가능.
		A.C.method2(); // 메서드도 바로 호출 가능

		A.C c = new A.C(); // c클래스에 대해 인스턴스 선언
		c.field1 = 1;
		c.method1();
		
		System.out.println();
		//로컬클래스
		a.method();
	}

}
