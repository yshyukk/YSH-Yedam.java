package com.yedam.java.ch0605;

public class SingletonTest {

	public static void main(String[] args) {
		//Singleton obj1 = new Singleton(); <-- private때문에 가려서 오류
		
		Singleton obj1 = Singleton.getInstance(); // new -->> 
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 Singleton 객체입니다.");
		}else {
			System.out.println("다른 Singleton 객체입니다.");
		}
		
	}

}
