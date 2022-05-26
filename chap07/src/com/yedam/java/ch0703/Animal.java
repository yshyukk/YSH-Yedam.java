package com.yedam.java.ch0703;

public abstract class Animal {	// 추상클래스 안에 추상메서드가 필수는 아니지만, 추상메서드가 하나라도 있는 클래스는 추상클래스!
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound(); //사운드라는 동작을 실행시키라는 강제성 부여.

}
