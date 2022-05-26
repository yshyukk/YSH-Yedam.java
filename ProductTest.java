package com.yedam.homework;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductSystem Product = new ProductSystem();
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while (run);
		
		System.out.println(" 1. 상품 수 | 2. 상품 및 가격  | 3. 제품별 가격 | 4. 분석 | 5. 종료");
		System.out.println("선택 > ");
		
		int selNum = Integer.parseInt(sc.nextLine());
		
		if (selNum == 1) {
			System.out.println("상품 수 > ");
			int size = sc.nextInt();
			Product.setListSize(size);
			System.out.println();
		}else if (selNum ==2 ) {
			System.out.println("상품 및 가격 > ");
			String name = sc.nextLine();
			int price = sc.nextInt();
			Product.putProduct(name, price);
					
		}else if (selNum ==3 ) {
			System.out.println("제품별 가격 > ");
			Product.pricetList();
			System.out.println();
		}else if( selNum ==4 ) {
			System.out.println("분석 : ");
			
			
			
		}
		

	}

}
