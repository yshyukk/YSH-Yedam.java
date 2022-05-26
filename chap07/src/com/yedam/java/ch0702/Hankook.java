package com.yedam.java.ch0702;

public class Hankook extends Tire{
	public Hankook(String location, int maxriotation) {
		super(location, maxriotation);
	}
	@Override
	public boolean roll() {
		++accumulateRotation;
		if (accumulateRotation < maxRotation) {
			System.out.println(location + "Hankook 수명 : " + (maxRotation - accumulateRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "Hankook 가 펑크");
			return false;
		}
	}
	
}
