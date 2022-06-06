package com.yedam.java.ch0801;
// 두 인터페이스를 상속하는 역할, TV클래스(구현)와 상관X
public interface Control extends RemoteControl, SmartControl{ //interface 상속도 extends
	
	
	public void plusService(); //추상메서드는 {} 없음
	
	
	
}
