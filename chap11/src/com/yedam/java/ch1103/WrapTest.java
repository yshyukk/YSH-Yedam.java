package com.yedam.java.ch1103;

public class WrapTest {

	public static void main(String[] args) {
		// 박싱, 언박싱
		Integer obj1 = new Integer(100);
		Integer obj2 = Integer.valueOf("100");
		Integer obj3 = 100;
		
		int val2 = obj2.intValue();
		int val3 = obj3;
		
		int result = obj2 + val3;
		
		
		//값 비교
		Integer object1 = 300;
		Integer object2 = 300;
		
		System.out.println("== 결과 : " + (object1 == object2));	//등호연산자를 사용하면 객체끼리 비교.
		System.out.println("언박싱 후 == 결과 : " + (object1.intValue() == object2.intValue())+"\n"); // 언박싱 후 등호연산자 사용.
		System.out.println("equals() 결과 : " + (object1.equals(object2)));
	}

}
