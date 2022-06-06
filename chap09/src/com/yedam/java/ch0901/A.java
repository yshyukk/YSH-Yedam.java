package com.yedam.java.ch0901;

public class A {
	// 생성자
	A() {
		System.out.println("A 인스턴스가 생성되었습니다.");
	}

	// 인스턴스 멤버 클래스
	class B {
		// 필드
		int feild1;
		// 생성자
		B() {
			System.out.println("B 인스턴스가 생성되었습니다.");
		}
		// 메서드
		void method1() {}
	}
	// 정적 멤버 클래스
	static class C {
		// 필드
		int field1;
		static int fiedl2;

		// 생성자
		C() {
			System.out.println("C 인스턴스가 생성되었습니다.");
		}

		// 메서드
		void method1() {}

		static void method2() {}		
	}
	void method() {
		// 로컬 클래스
		class D {	//노란줄 = 코드는 생성됐지만 실제로 사용하는 게 없다
			//필드		// 로컬 클래스는 클래스 안에 반드시 사용되는 코드가 있어야 함.
			int field1;
			//생성자
			D (){
				System.out.println("D 인스턴스가 생성됨.");
			}
			//메서드
			void method1() {}
		}
		D d = new D(); // <== 로컬 클래스는 클래스 안에 반드시 사용되는 코드가 있어야 함. 생성자만들때 A.D가 아니라 자기자신으로 생성자 선언.
		d.field1 = 1;	
		d.method1();
		
		
	}
}
