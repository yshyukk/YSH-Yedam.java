package com.yedam.java.ch0605;

public class Cartest {

	public static void main(String[] args) {
		Car myCar = new Car("포르쉐"); // <-- 앞에 생성자가 있기때문에 기본생성자 생성되지 않음. 
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		System.out.println(yourCar.speed);
		yourCar.run();
		
		

	}

}
