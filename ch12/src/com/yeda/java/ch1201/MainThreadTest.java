package com.yeda.java.ch1201;

public class MainThreadTest {
	// 흐름이 하나 밖에 없어서 순차적으로 나옴.
	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			System.out.println("현재 순서 : " + i);
			try {
				Thread.sleep(500);	//500 = 0.5초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
