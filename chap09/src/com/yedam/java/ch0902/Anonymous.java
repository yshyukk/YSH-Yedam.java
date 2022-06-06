package com.yedam.java.ch0902;

public class Anonymous { // 자식클래스
	// 필드
	Person field = new Person() { // <---부모클래스 호출.
		// 필드
		String job = "회사원";

		// 메서드
		void work() {
			System.out.println("출근합니다.");
		}

		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	}; // <--익명 자식객체 선언 및 사용방법
	// 생성자

	// 메서드
	void method1() {
		// 로컬변수
		Person var = new Person() { // <---부모클래스 호출.
			// 자식객체에 대한 필드
			String job = "건물주";

			// 자식객체에 대한 메서드
			void walk() {
				System.out.println("산책합니다.");
			}

			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
		var.wake();
		// 똑같은 부모클래스의 자식객체라고 해서 같은건 아님.
	}

	void method2(Person person) {
		person.wake();
	}

}
