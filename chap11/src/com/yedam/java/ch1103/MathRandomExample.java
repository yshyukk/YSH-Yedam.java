package com.yedam.java.ch1103;

public class MathRandomExample {

	public static void main(String[] args) {
		int num = (int) (Math.random()*6) +1;
		System.out.println(" 주사위 눈: "+ num);
		
		
		// +1 -- 몇번부터 시작할것인가
		// *6 -- 내가 원하는 갯수
	}

}
