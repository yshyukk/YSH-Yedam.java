package com.yedam.java.ch0801;
//두 인터페이스를 구현하는 역할, Control(상속)과 상관X
//public class TV implements RemoteControl, SmartControl { // 상속클래스는 extends 구현클래스는 implements

public class TV implements Control { // Control(상속)인터페이스를 사용하려면 Control로														//

	private int volume; // RemoteControl은 상수필드만 가지기 때문에 구현클래스가 volume필드를 가지고 있어야함.

	@Override
	public void turnON() {
		System.out.println("TV를 켭니다.");

	}

	@Override
	public void turnoff() {
		System.out.println("TV를 끕니다.");

	}

	@Override
	public void setVolume(int volume) { //현재 볼륨을 설정
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume < RemoteControl.MIN_VOLUUME) {
			this.volume = RemoteControl.MIN_VOLUUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	public void searchInternet(String url) {
		System.out.println(url = "을 검색합니다.");
	}
	public void executeApp(String app) {
		System.out.println(app + "을 실행합니다.");
	}

	@Override
	public void plusService() {
		
		
	}

}
