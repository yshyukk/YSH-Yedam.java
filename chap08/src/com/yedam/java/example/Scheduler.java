package com.yedam.java.example;

public interface Scheduler { //고객센터가 돌아가는 
	//직원이 고객을 할당받는 방법 -> 고객이 끊고 다음고객을 응대
	public void getNextCall();
	//관리자가 직접 대기열을 관리
	public void sendCallToaAgent();
	//
}
