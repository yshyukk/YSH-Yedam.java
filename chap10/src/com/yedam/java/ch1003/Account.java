package com.yedam.java.ch1003;

public class Account {
	private long balance;

	public long getBalance() {
		return balance;
	}

	public void deposit(int money) {
		balance += money;
	}

	public void wihtDraw(int money) throws BalanceInsufficientException{ 
		if (balance < money) { // 잔액이 부족할때 예외를 발생 == 예외클래스를 실행한다.
			throw new BalanceInsufficientException("잔고부족 : " + (money - balance) + "모자랍니다.");
		
			// 예외클래스를 사용하기 위해서 throw를 사용해야 함.
			// 예외클래스를 사용하기 위해서 예외를 처리하기 위해 메서드에 붙여넣어야함.
			// throws를 메서드에 붙여줘야 java가 인식.
			// 
		}
		
		balance -= money;
	}
}
