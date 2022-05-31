package com.yedam.java.ch0901;

public class Outter {
	String field = "바깥클래스 - 필드";

	void method() {
		System.out.println("바깥클래스 - 메소드");
	}
	void methodA() {
		System.out.println("바깥클래스 - 메소드 A"); 
	}
	//인스턴스 멤버 클래스
	class Nested{
		String field = "중첩클래스 - 필드";
		void method() {
			System.out.println("중첩클래스 - 메소드");
		}
		
		void print() {
			
			methodA();
			System.out.println(field); // field 로 호출하면 = this.field
			method();	// Nested의 메서드
			System.out.println(Outter.this.field);//Outter의 필드
			Outter.this.method();//Outter의 메써드 호출
		}
	}
	
	interface I {
		int FIELD = 100;
		
		void method();
	}
	static interface N {
		int FIELD = 100;
		void method();
	}
}
