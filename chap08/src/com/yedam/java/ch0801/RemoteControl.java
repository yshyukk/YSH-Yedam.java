package com.yedam.java.ch0801;

public interface RemoteControl {
	//상수 필드
	public static final int MAX_VOLUME = 10;	// 인터페이스에서 상수 선언할 때는 반드시 static final , 값을 주지 않으면 오류
	public int MIN_VOLUUME =0;	// static final을 선언하지 않으면 자동으로 static final을 만들어버림
	
	
	
	//추상 메서드
	public abstract void turnON(); // 추상메서드는 {} 없음.
	public void turnoff();	// 인터페이스 abstract void를 선언하지 않으면 자동으로 생성
	public void setVolume(int volume);
	

}
