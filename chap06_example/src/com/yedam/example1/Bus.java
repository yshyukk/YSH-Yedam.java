package com.yedam.example1;

public class Bus {

	// 필드
	private int busNumber;
	private int money;
	private int passengerCount;
	private int pay;

	// 생성자
	public Bus(int busNumber, int pay) {
		this.busNumber = busNumber;
		this.pay = pay;
	}

	// 메서드
	public int getPay() {
		return pay;
	}

	public void take(int money) {
		this.money += money;
		this.passengerCount++;

	}

	public void showInfo() {
		System.out.println(busNumber + "의 승객은 " + passengerCount + "명, 수입은" + money + "원 입니다.");
		
		
	}
}