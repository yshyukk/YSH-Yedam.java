package com.yedam.java.ch1003;
// 예외클래스
public class BalanceInsufficientException extends Exception {
	//예외클래스는 반드시 최상위 클래스를 상속 받아야함.
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
