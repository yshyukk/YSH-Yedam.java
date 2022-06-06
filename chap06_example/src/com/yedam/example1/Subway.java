package com.yedam.example1;

public class Subway {
	//필드
	private String lineNumber;
	private int money; // 승객들이 내는 돈이 필요하므로
	private int passengerCount; // 승객들의 수
	private int pay;
	
	//생성자
	public Subway(String lineNumber, int pay) { // lineNumber와 pay의 인스턴트를 생성(값 초기화)
		this.lineNumber = lineNumber;
		this.pay = pay;
	}
	
	//메서드
	public int getPay() {	// 요금이 얼마인지 알려주기 위한 동작
		return pay;
	}
	public void take(int money) {
		this.money += money;	// 요금 누적
		this.passengerCount++;	// 승객 수 누적
	}
	public void showInfo() {
		System.out.println(lineNumber + "의 승객은 " + passengerCount + "명, 수입은" + money + "원 입니다." );
		
		
	}
}
