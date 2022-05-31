package com.yedam.example1;

public class Student { 
	//필드(속성) <--- 필드만들때는 항상 private	, 대중교통을 이용하기 위해 필요한 학생의 정보
	private String name; 
	private int money;
	
	//생성자 <--생성자로 값을 초기화, getter setter 필수는 아님
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	//메서드(동작)
	public void take(Subway subway) {	//무엇을 탈 것인지에 대한 정보를 갖기 위해 매개변수 입력
		int pay = subway.getPay(); 		//교통비에 대한 정보
		this.money -= pay;
		subway.take(pay);
	}
	public void take(Bus bus) { //<---메서드 오버로딩
		int pay = bus.getPay();
		this.money -= pay;
		bus.take(pay);
	}
	
	
	public void showInfo() {
		System.out.println(name + "님의 남은 금액은" + money + "입니다.");
	}
	
}
