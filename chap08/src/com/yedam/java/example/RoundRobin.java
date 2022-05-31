package com.yedam.java.example;

public class RoundRobin implements Scheduler{

	@Override
	//상담원에게 동일하게 업무를 배분
	public void getNextCall() {
		System.out.println("상담 전화를 순서대로 대기열에 보냅니다.");
		
	}

	@Override
	public void sendCallToaAgent() {
		System.out.println("대기열이 높은 순서대로 직원에게 보냅니다.");
		
	}
	
	
}
