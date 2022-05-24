package com.yedam.java.ch0605;

public class Singleton {
	
	//필드 == 속성
	private static Singleton singleton = new Singleton(); 
	
	//생성자	== 인스턴스 생성
			//	 인스턴스 => 기능
			//   클래스 => 모든 인스턴스의 기반
	private Singleton() {}	//<-- 기본생성자 앞에 private
	
	//메소드 == 동작
	public static Singleton getInstance( ) {
		return singleton;
	}
}

// 정적 메서드는 클래스에 있음 <--인스턴스 X