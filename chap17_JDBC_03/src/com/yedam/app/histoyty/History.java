package com.yedam.app.histoyty;

public class History {

	private int productId;
	// 1: 입고, 2: 출고
	private int productCategory;
	private int productAmount;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	// toString 별도로 overriding 하지않음.
	// --> why? 이 클래스의 정보만 따로 출력할 일 없어서
	
}
