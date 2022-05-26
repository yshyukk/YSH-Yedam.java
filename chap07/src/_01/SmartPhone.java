package _01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {
	
	public SmartPhone(String model, String color) {
		super(model, color);
	}
	@Override
	void print() {	// final 해놔서 Override 불가
		System.out.println("꺼진다?");
		super.powerOff();	//	final 해도 실행은 가능
		super.print();
	}

	@Override
	public void bell() {
		
		super.bell();
		System.out.println("벨 소리 : --------");
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		super.call();
		System.out.println("전화왔다!");
	}
	
	private void print() {
		super.bell();
		System.out.println("테스트");
	}
}
