package com.yedam.java.ch0702;

public class ChildTest2 {

	public static void main(String[] args) {
		GranFa pa = new Father();
		pa.method();
		pa = new Uncle();
		//문법적 오류는 없지만 실행하면 실행X
		//why? 자바는 타입을 먼저 보기때문에 어쨌든 GranFa니까 문법적 오류는 x 
		// but pa가 Uncle인데 Father와 연관성없기때문에 실행x
		// 그래서 instanceof로 pa가 Father인지 확인해야함.
		
		System.out.println();
		if(pa instanceof Father) {
			Father fa = (Father) pa;
			fa.method();
			fa.method2();
		}else {
			System.out.println("pa 변수가 가지고 있는 인스턴스는 Father가 아닙니다.");
		}
		
		
	}

}
