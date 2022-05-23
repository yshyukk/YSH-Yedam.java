package com.yedam.java.ch0602;

public class Car {
	// 필드
	String company = "현대자동차";
	String model = "그렌저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;

	Car() { // 기본생성자 : class내 어떤 class도 없어야 됨. <== 인스턴트를 생성하기 위해 Java가 기본생성자 만듦.
	}

	Car(String color) {
		this.color = color; // this는 class 내부에서만 사용할 수 있는 연산자.
	}
	
	Car(String model, String color ) {
		this.model = model;
		this.color = color;
	}

	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;

	}
}



