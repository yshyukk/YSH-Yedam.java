package com.yedam.java.example1;

public class Gold extends Customer{
	
	//필드	
	double discountRatio;
	
	//생성자
	public Gold(int customerId, String customerName) {
		super(customerId, customerName); //super() = 내가 상속받는 부모클래스의 ()안의 정보를 쓰겠다.
		this.customerGrade = "Gold"; // 변경되는 내용
		this.bonusRatio = 0.02;	// 변경되는 내용	
		this.discountRatio = 0.1;	// 추가되는 내용
	}
	
	//메소드
	@Override
	public int calPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;	//calPrice는 Customer클래스에 있음. Gold클래스에서 적립율을 바꿔줬으니까 골드등급의 적립율이 적용됨.
		
		return (int)(price *  (1-discountRatio)); //할인율 적용 > int - double은 double인데 calPrice는 int를 받으므로 int(int-double)로 변환.
	}
	
	public String showCustomerinfo() {
		return customerName + "님의 등급은" + customerGrade + "이며, 보너스 포인트는" + bonusPoint +"입니다.:";
		
	}
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	public double getDiscountRatio() {
		return discountRatio;
	}
}
