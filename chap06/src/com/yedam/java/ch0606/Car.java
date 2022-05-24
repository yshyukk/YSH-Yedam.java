package com.yedam.java.ch0606;

public class Car {
	//필드
	private int speed;
	private boolean stop;
	
	//생성자 <-- 인스턴스 (초기화)생성 메서드
	
	//메소드
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if ( speed < 0) {
			this.speed = 0;
			return;
		}else {
			this.speed = speed;
		}
	}
	public boolean isStop() {	//<--- boolean은 이다/아니다 라서 is
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
