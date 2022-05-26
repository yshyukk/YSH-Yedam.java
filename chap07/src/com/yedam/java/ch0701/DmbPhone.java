package com.yedam.java.ch0701;

public class DmbPhone extends Phone {
	int ch;

	public DmbPhone(String model, String color) {
		// super(); <--- 부모클래스의 생성자를 호출하지 않아도 java가 알아서 super();를 사용해서 호출
		// 부모클래스 생성자가 디폴트값일때만 java가 super를 디폴트로 함.
		super(model, color);
		// super.model = model; // 부모클래스에 접근할 때는 this -> super
		// super.color = color;
		this.ch = 10; // this는 인스턴스에만 접근 (클래스에 접근X)

	}

	void trunOnDmb() {
		System.out.println("채널 " + ch + "번 방송 수신을 시작합니다.");
	}

	void trunOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}

	@Override
	protected void bell() {
		
		super.bell();
	}

	@Override
	void call() {
		
		super.call();
	}

	void changeCh(int ch) {
		this.ch = ch;
		System.out.println("채널" + ch + "번으로 변경합니다.");
	}
	
	//	상속이 일어날 수 있는 경우에는 Protected 이상 (public)사용

}
