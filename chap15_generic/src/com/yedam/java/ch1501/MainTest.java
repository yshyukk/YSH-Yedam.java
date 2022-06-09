package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		//모든 값을 받아 올 수 있지만 받아올때 무엇을 받아와야되는지 확인해야함.
		Bag bag = new Bag();
		
		bag.set(new Note());
		Note note =(Note)bag.get();
		
		bag.set("신운하");
		String name = (String)bag.get();
		
		//이 generic타입을 뭘로 할건지 정해줌.
		Box<Note, String, Integer> box = new Box<>();
		//set할때 내가 집어 넣은 타입들이 generic타입에 뭐와 대응되는지
		box.setT(new Note());
		box.setK(10);
		box.setV(" ");
		
		Note memo = box.getT();
		int num = box.getk();
		String str = box.getv();
	
		Box<Car, Bus, Taxi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setK(new Taxi());
		vehicle.setV(new Bus());
	}

}

class Car {
}

class Bus {
}

class Taxi {
}