package com.yedam.java.ch0703;

//추상클래스
// : 단독으로는 인스턴스 생성X 
public abstract class Phone {

	// 필드
	public String model;
	public String color;

	// 생성자
	public Phone(String model, String Color) {
		this.model = model;
		this.color = color;

	}

	// 메소드
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	public abstract void bell();
								// 추상메서드를 추가하면 이 기능을 사용하라는 강제성을 띄게 됨. 
	{ 							// Phone에서 기능을 설정하지 않음. 실행블록X ( {} = 실행블록 )
								// abstract걸면 DmbPhone 클래스에서 오류가 남... -> 메서드 만들어야 함.
		System.out.println("벨이 울립니다.");
		System.out.println("벨소리!@!@#!@#");
									
	}

}
