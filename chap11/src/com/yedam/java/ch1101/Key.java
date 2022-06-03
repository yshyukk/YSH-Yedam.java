package com.yedam.java.ch1101;

public class Key {
	public int number;

	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Key) {
			Key key = (Key) obj;
			if (number == key.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() { // hashCode : 물리적으로 동등한지 #주의 : Map
		return number; // equals : 논리적으로 동등한지
		
		// hashCode == equals 가 같으면 같은 값.
	}

	@Override
	public String toString() {
		return "Key [number=" + number + "]";
	}
}
