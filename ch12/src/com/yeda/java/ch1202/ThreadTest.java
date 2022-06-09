package com.yeda.java.ch1202;

// 
public class ThreadTest {

	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
		thread.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		thread.setStop(true);
		
		//익명객체 : sleep이 일어나길 기다리지 않아도 됨.
		System.out.println("-------------------------------------------------------");
		//익명자식객체 만들기
		Thread sub = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(Thread.interrupted())
						break;
					System.out.println("*********실행 중");
				}
				System.out.println("*********자원 정리");
				System.out.println("*********종료");
			}
		};
		sub.start();
		try {
			Thread.sleep(500);
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub.interrupt(); // 자동으로 종료.
	}

}
