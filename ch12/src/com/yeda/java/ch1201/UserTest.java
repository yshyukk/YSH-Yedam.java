package com.yeda.java.ch1201;

public class UserTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		
		User user1 = new User();
		user1.setCalculaotr(cal);
		user1.start();
		//200
		
		Calculator calTemp = new Calculator();	//동일한 thread에서 각각 다른 인스턴스를 사용하면 동작이 가능.
		User user2 = new User();				//but 필드값이 static이면 X
		user2.setCalculaotr(cal);
		user2.start();
		//300
	}

}
