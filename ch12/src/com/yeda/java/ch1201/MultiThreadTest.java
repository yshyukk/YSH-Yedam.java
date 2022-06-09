package com.yeda.java.ch1201;

public class MultiThreadTest {
	//Thread와 객체는 다른 개념!
	//main 메써드도 하나의 thread!
	//Thread.currentThread() : 지금 진행되는 thread의 내용을 가져올때(=객체로 가져올때)
	//thread.setName() : 스레드 이름 바꾸기
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("메인 스레드 : " + main.getName());
		Runnable a = new ThreadA();
		Thread thread = new Thread(a);
		thread.setName("threadA");
		//ThreadB thread = new ThreadB();
		System.out.println("작업 스레드 : " + thread.getName()); //thread.getName() : 스레드는 이름값을 가지고 있음.
		thread.start();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
