package com.yeda.java.ch1201;

//Calculator에 접근하는 user
public class User extends Thread {
	private static int serial = 0;
	private Calculator cal;
	private int numInfo;
	
	public void setCalculaotr(Calculator cal) {
		serial += 100;
		this.setName("User" + serial); // this = thread를 상속받은 User.
		this.cal = cal;
		this.numInfo = serial;
	}
	@Override
	public void run() {
		cal.setMemory(100 + numInfo);
	}
}
