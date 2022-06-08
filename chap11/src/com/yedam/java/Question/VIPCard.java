package com.yedam.java.Question;

public class VIPCard implements Payment {

	private String name;
	private String grade;
	private double saleRatio;
	private int point;
	private double pointRatio;

	public VIPCard() {
		this.grade = "GOLD";
		this.pointRatio = 0.03;
		this.saleRatio = 0.1;
		this.name = "VIPCard";
	}

	public int offline(int price) {
		point += price * this.pointRatio;

		return (int) (price * (1 - (saleRatio + OFFLINE_PAYMENT_RATIO)));

	}

	public int online(int price) {
		point += price * this.pointRatio;

		return (int) (price * (1 - (saleRatio + ONLINE_PAYMENT_RATIO)));
	}

	public int simple(int price) {
		point += price * this.pointRatio;

		return (int) (price * (1 - (saleRatio + SIMPLE_PAYMENT_RATIO)));

	}

	public void showCardInfo() {
		System.out.println("==============================");
		System.out.println("카드명 : " + name);
		System.out.println("적용 등급 : " + grade);
		System.out.println("할인율 : " + this.saleRatio);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 " + point);
	}

}
