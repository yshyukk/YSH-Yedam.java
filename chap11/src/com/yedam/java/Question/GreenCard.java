package com.yedam.java.Question;

public class GreenCard implements Payment {
	private String name;
	private String grade;
	private int point;
	private double pointRatio;

	public GreenCard() {
		this.grade = "Silver";
		this.pointRatio = 0.05;
		this.name = "GreenCard";
	}

	public int offline(int price) {
		point += price * this.pointRatio;

		return (int) (price * (1- OFFLINE_PAYMENT_RATIO));

	}

	public int online(int price) {
		point += price * this.pointRatio;

		return (int) (price * (1- ONLINE_PAYMENT_RATIO));
	}

	public int simple(int price) {
		point += price * this.pointRatio;

		return (int) (price * (1- SIMPLE_PAYMENT_RATIO));

	}

	public void showCardInfo() {
		System.out.println("==============================");
		System.out.println("카드명 : " + name);
		System.out.println("적용 등급 : " + grade);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 " + this.pointRatio);
	}

}
