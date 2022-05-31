package com.yedam.java.ch0802;

public class Car {
	//필드
	Tire frontLeftTire = new KumhoTire();
	Tire frontRightTire = new KumhoTire();
	Tire backLeftTire = new KumhoTire();
	Tire backRightTire = new KumhoTire();
	
	void run( ) {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
		
	}
}
