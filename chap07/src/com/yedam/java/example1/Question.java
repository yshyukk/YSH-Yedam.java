package com.yedam.java.example1;

public class Question {
	
	
	/*
	 * 쇼핑몰 
	 	# Customer 클래스
	 	- 고객아이디, 이름, 고객등급 
	 	- 보너스 포인트, 포인트 적립율
	 	- 기본등급 : SILVER
	 	-보너스 포인트 적립율 : 1%
	 	
	 	#Gold 클래스		--> customer클래스를 상속. ( 할인율은 추가, 할인율 제외 나머지는 동일 )
	 	- 고객아이디, 이름. 고객등급
	 	- 보너스 포인트, 포인트 적립율, 할인율
	 	- 등급 : GOLD
	 	- 보너스 포인트 적립율 : 2%
	 	- 할인율 : 10% 
	 	
	 	#Vip 클래스
	 	- 추가내용 : 할인율(customer에 할인율없으니까), 담당상담원
	 	- 등급 : VIP
	 	- 적립율 : 5% 
	 	- 할인율 : 15%
	 	
	 */

	public static void main(String args[]) {
	
		new CustomerSystem(); //repo에 생성자에 while문으로 해놨기때문에 이거하나로 시작
		
		
		
		/*
		Vip vip = new Vip(111, "Vip_1");
		Gold gold = new Gold(11, "gold_1");
		Customer customer = new Customer(1, "Customer_1");
		
		
		System.out.println(vip.calPrice(100));
		System.out.println(gold.calPrice(100));
		System.out.println(customer.calPrice(100));
*/
	}
}
