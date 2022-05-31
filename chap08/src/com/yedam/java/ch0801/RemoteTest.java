package com.yedam.java.ch0801;

public class RemoteTest {

	public static void main(String[] args) {
		//RemoteControl rc = new TV();
		
		RemoteControl rc = new Audio();
		rc.turnON();
		rc.setVolume(5);
		rc.turnoff();
		
		SmartControl sc = new TV();
		sc.searchInternet("네이버");
		sc.executeApp("구글");
		
	}

}
