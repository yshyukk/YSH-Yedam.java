package com.yedam.java.ch0702;

public class kumhoTire extends Tire {

	public kumhoTire(String location, int maxriotation) {
		super(location, maxriotation);
	}

	@Override
	public boolean roll() {
		++accumulateRotation;
		if (accumulateRotation < maxRotation) {
			System.out.println(location + "kumhoTrie 수명 : " + (maxRotation - accumulateRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "kumhoTireTire가 펑크");
			return false;
		}
	}
}
