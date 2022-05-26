package com.yedam.java.ch0605;

public class Car {
	//필드
	public String model;
	int speed;
	
	//정적 필드 - 생산수량
	public static int count;
	
	//생성자 <-- 클래스와 동일한 이름
	public Car(String model){
		this.model = model;	// <-- this로 필드 접근. 강제로 생성자 생성하면 기본 생성자 생성X
		count++;				// static에서는 this. 사용 X
		
	}
	//메소드
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void run() {
		for(int i=10; i<=50; i+=10 ) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속: )");
			System.out.println(this.speed + " km/h)");
		}
	}
}

