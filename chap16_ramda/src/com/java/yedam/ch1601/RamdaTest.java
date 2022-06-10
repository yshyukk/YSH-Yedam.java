package com.java.yedam.ch1601;

public class RamdaTest {

	public static void main(String[] args) {
		// 매개변수 X, 리턴타입 X 인 람다식
		MyFunInterfaceA fa = () -> {
			String str = "method call1";
			System.out.println(str);
		};

		fa.method(); // 메서드를 호출하면 실행.

		fa = () -> {
			System.out.println("method call2");
		};
		fa.method();
		fa = () -> System.out.println("method call3"); // 실행문이 하나일때는 {} 생략가능!
		fa.method();

		// 매개변수 O, 리턴타입 X 인 람다식
		// interface내에 매개변수에 대해 선언해줘야함.
		MyFunInterfaceB fb = (int x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fb.method(5);

		fb = (x) -> {
			System.out.println(x * 5);
		};
		fb.method(7);

		// 매개변수 O, 리턴타입 O 인 람다식
		MyFunInterfaceC fc = (int x, int y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fc.method(1, 2));

		fc = (x, y) -> {
			return x + y;
		};
		System.out.println(fc.method(1, 5));

		// return 구문이 있을때 return 구문만 실행할때는 표현식만 써주면 됨.
		fc = (x, y) -> x + y;
		System.out.println(fc.method(6, 5));

		fc = (x, y) -> Math.max(x, y);
		fc = (x, y) -> {
			// int result = Math.max(x,y);
			// return result;

			return Math.max(x, y);
		};
		fc = (x, y) -> Math.max(x, y);
		System.out.println(fc.method(10, 12));
		
		int val1 = 10;
		int val2 = 20;
		
		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
		};
		fa.method();
	}

}
