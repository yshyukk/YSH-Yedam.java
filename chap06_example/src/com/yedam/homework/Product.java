package com.yedam.homework;

public class Product { // 상품에 대한 정보를 가지는 클래스
	
	//필드
	private String name;
	private int price;
	
	//생성자
	public Product() {}
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String setName(String name) {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(int Pirce) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}

}
