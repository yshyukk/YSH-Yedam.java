package com.java.yedam.ch1601;

public class MainTest {
	/*	
	 * 
	 */
	public static void main(String[] args) {
		MyFunctionalInterface fi = () -> {
			System.out.println("람다식 실행");
		};

		fi.method();

		/*
		 * ============================================================================
		 * ramda식 말고 정석대로 new연산자 사용해서 만들면.. MyFunctionalInterface mfi =new
		 * MyFunctionalInterface() {
		 * 
		 * @Override public void method() { System.out.println("익명 구현 객체 실행")
		 * 
		 * }
		 * 
		 */

	};
}
