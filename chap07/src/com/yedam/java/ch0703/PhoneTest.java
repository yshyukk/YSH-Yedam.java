package com.yedam.java.ch0703;

public class PhoneTest {

	public static void main(String[] args) {
		/*Phone phone = new Phone("Z플립", "블랙") ;
		 phone.powerOn();
		 추상클래스에서는 new연산자 사용X
		*/
	DmbPhone dmbPhone = new DmbPhone("Z플립", "블랙");
		dmbPhone.powerOn();
		dmbPhone.showDmb();
	}

}
