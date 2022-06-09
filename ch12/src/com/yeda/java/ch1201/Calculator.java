package com.yeda.java.ch1201;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	// 동기화 method
	// synchronized가 작동하면 먼저 입력받은 값이 쉬는동안 다른 값으로 입력되는 것을 막아줌. 그래서 순차적으로 결과값이 나옴.
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : " + info.getName() + ", memory : " + this.memory);
	}
}
