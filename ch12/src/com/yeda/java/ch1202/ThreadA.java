package com.yeda.java.ch1202;

public class ThreadA extends Thread {
	private boolean stop;
	//sleep을 이용하지 않고 stop flag를 사용한 방법.
	public void setStop(boolean stop) {
		this.stop = stop;

	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("실행중");
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	}

}
