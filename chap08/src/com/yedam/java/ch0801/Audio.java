package com.yedam.java.ch0801;

public class Audio implements RemoteControl {

	private int volume;
	
	@Override
	public void turnON() {
		System.out.println("오디오를 켭니다.");

	}

	@Override
	public void turnoff() {
		System.out.println("오디오를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUUME) {
			this.volume = RemoteControl.MIN_VOLUUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 볼륨 : " + this.volume);
		 
	}

}
