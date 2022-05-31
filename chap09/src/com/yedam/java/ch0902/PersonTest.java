package com.yedam.java.ch0902;

public class PersonTest { // 익명자식객체

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();

		// 필드 - 익명 자식 객체
		anony.field.wake();
		System.out.println();

		// 로컬변수 - 익명 자식 객체
		anony.method1();
		System.out.println();

		// 매개변수 - 익명 자식 객체
		anony.method2(new Person() {
			// 필드
			String job = "학생";

			// 메서드
			void study() {
				System.out.println("공부합니다.");
			}

			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		});
		// 익명자식객체는 다시 호출할 수 없음. study와 job은 호출 할 수없음.
		// overriding 된것만 실제로 실행됨??
	}

}
