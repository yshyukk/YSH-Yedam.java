package com.yedam.java.ch0802;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car();
		//차를 운행
		myCar.run();
		
		//타이어를 한국타이어로 교체
		myCar.frontLeftTire = new HankookTire();
		myCar.frontRightTire = new HankookTire();
		myCar.backLeftTire = new HankookTire();
		myCar.backRightTire = new HankookTire();
		//교체 후 차 운행
		myCar.run();

	}

}
