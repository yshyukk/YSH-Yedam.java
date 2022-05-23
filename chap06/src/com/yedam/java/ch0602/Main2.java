package com.yedam.java.ch0602;

public class Main2 {

	public static void main(String[] args) {
		Car myCar = new Car("Blue");
		
		
		Car yourCar = new Car("티볼리", "Silver");
		
		
		Car newCar = new Car("레이", "yello", 120);
		
	
		System.out.println(myCar.color);
		
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		
		System.out.println(newCar.model);
		System.out.println(newCar.color);
		System.out.println(newCar.maxSpeed);
	}
	
}
