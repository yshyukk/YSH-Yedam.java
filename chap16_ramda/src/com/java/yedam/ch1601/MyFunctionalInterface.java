package com.java.yedam.ch1601;

// ramda식에서 이용되는 interface에는 하나의 메소드만.

@FunctionalInterface	
// 지금 interface가 ramda식 interface로 사용될 수 있다는 의미.
// @FunctionalInterface로 선언하면 
// 						추가로 메소드 선언하면 오류.
//						꼭 ramda식으로만 사용할 필요는 없음. interface상 하나의 method만 있다고 제한하는 의미.

public interface MyFunctionalInterface {
	public void method();
	/*
	 * public void method2();
	 * 
	 * interface안에서 메서드를 추가해도 오류는 없지만
	 * Main에서 메서드를 지정하지 않기때문에 무엇을 메서드로 실행해야 할지 모름.
	 */
}
