package com.yedam.homework;

public class ProductSystem {
	private Product[] list; //<--상품명을 담을 배열 선언
	private int index; //<-- 
	
	public ProductSystem(){
		index = -1;
	
	//1. 상품 수 입력
	public void setListSize(int size) {
		list = new Product[size];
	}
	//2. 상품 및 가격 입력
	public void putProduct(String name, int price) {
		Product product = new Product();	//<-- 값을 입력 받기 위한 임시변수
		prodcut.setName(name);
		product.setPrice(price);
		
		list[++index] = product;
	}
	//3. 제품별 가격 출력
	public void printList() {
		for(int i=0; i<=index; i++) {
			System.out.println(index[i].getName() + " : " + );
			
		}
	}
	//4. 분석
	// hint : 우리가 입력 받아야 하는 것은 상품명 <-- 어제와 필드가 달라짐
	
	
	}
	
}
