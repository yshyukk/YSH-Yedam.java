package com.yedam.java.example1;

public class Vip extends Customer{
	//필드
	double discountRatio;
	String counselor;
	
	//생성자
	public Vip(int customerId, String customerName, String counselor) { //customer에는 counselor가 없음 , counselor는 외부에서 입력받아 쓰기때문에 넣어줘야함.
		super(customerId, customerName);// == customerId, customerName은 Customer클래스로 넘겨주고
		this.customerGrade = "Vip";
		this.bonusRatio = 0.05;	
		this.discountRatio = 0.15;	
		this.counselor = counselor;
		
	}
	
	@Override
	public int calPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		
		return (int)(price * (1-discountRatio));
	}
	public String showCustomerinfo() {
		return customerName + "님의 등급은" + customerGrade + "이며, 보너스 포인트는" + bonusPoint +"입니다. 담당 상담원은 + " + counselor + "입니다.";
	}
	
	@Override
	public String showInfo() {
		return super.showInfo() + "\n" + "담당 상담원은" + counselor + "입니다.";
	}
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	public double getDiscountRatio() {
		return discountRatio;
	}
	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}
	public String getCounselor() {
		return counselor;
	}
}
