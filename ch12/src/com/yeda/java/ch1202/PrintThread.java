package com.yeda.java.ch1202;

public class PrintThread extends Thread {
	@Override
	public void run() {
		// 작업 thread가 실행할 내용.
		try {
			while (true) { // 무한반복
				System.out.println("실행중");
				Thread.sleep(1000);
			}
		}
		// while 문에서 sleep이 발생하면 catch문 실행.
		// interrupt발생 했을때 종료 => try catch문을 while문을 감싸는 형태로.
		//					 종료 X 계속 실행 => while문 안으로.(일시적으로 추가작업이 필요한 경우)
		catch (InterruptedException e) {	
			System.out.println("interrupt method 실행");
		} 
		System.out.println("자원 정리");
		System.out.println("종료");

	}
	
	
}
