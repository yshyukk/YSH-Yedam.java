package com.yedam.example1;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student("Hong", 5000);
		Subway subway = new Subway("2호선", 1500);
		Bus bus = new Bus(937, 1200);
		
		hong.take(subway);
		hong.take(bus);	
		
		hong.showInfo();
		subway.showInfo();
		bus.showInfo();
	}

}
