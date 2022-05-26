package com.yedam.java.example1;
//Customer -> Gold -> Vip -> CustomerSystem -> Repo -> MainTest 

public class Customer { //repo에 저장되는 클래스

	//필드
	int customerId;
	String customerName;
	String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	//생성자
	public Customer() {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
		
	}
	
	public Customer(int customerId, String customerName) { //super() = 내 위의 생성자를 실행한다.
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	//메소드

	public int calPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		
		return price;	
		
	}
	public String showInfo() {
	      return customerName + "님의 등급은 " 
	            + customerGrade + "이며, 보너스 포인트는 " 
	            + bonusPoint + "입니다";
	   }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
		
}
