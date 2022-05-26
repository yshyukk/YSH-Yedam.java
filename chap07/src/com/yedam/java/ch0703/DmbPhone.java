package com.yedam.java.ch0703;

public class DmbPhone extends Phone {

	public DmbPhone(String model, String color) {
		super(model, color);
	}
	@Override
	public void powerOn() {
		super.powerOn();
		System.out.println("부팅이 완료되었습니다.");
	}
	public void showDmb() {
		System.out.println("DMB를 실행합니다.");
	}
}
