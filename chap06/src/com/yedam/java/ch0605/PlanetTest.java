package com.yedam.java.ch0605;

public class PlanetTest {

	public static void main(String[] args) {
		System.out.println("pi : " + Planet.pi);
		//Planet.pi = Math.pi;
		
		Planet earth = new Planet(6400);
		System.out.println("earth : " + earth.radius);
		//earth.radius = 6000; 
		Planet moon = new Planet(1500);
		System.out.println("moon : " + moon.radius);
	}
	// 상수를 만들 때 = static final

}
