package com.yedam.java.ch0802;

public class DrvierTest {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		driver.drive(taxi);
		System.out.println("===================");
		driver.drive(bus);

	}

}
