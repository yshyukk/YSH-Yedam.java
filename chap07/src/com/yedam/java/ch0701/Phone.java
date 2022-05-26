package com.yedam.java.ch0701;

public class Phone {
	String model;
	String color;
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}

	final void powerOn() {	// = powerOn 이라는 동작 "전원을 켭니다"를 출력합니다.
		System.out.println("전원을 켭니다.");
	}
	
	final void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	protected void bell() {
		System.out.println("벨이 울리고 진동을 일으킵니다.");
	}
	void call() {
		System.out.println("통화를 합니다.");
	}
}
