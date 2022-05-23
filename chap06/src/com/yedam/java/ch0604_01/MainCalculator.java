package com.yedam.java.ch0604_01;

import java.util.Scanner;

public class MainCalculator {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		Scanner sc = new Scanner(System.in);

		calculator.setArrayNumSize(10);

		int selectNo = 0;

		while (true) {		
			System.out.println("1. 더하기 | 2. 빼기 | 3. 곱하기 | 4. 나누기 | 5. 종료");
			selectNo = Integer.parseInt(sc.nextLine());

			if (selectNo == 1) {
				System.out.println(" 더할 값 ");
				int pl = Integer.parseInt(sc.nextLine());
				calculator.plus();
			} else if (selectNo == 2) {
				System.out.println(" 뺄 값");
				int mi = Integer.parseInt(sc.nextLine());
				calculator.subtracted();
			} else if (selectNo == 3) {
				System.out.println(" 곱할 값");
				int mul = Integer.parseInt(sc.nextLine());
				calculator.multiplicated();
			} else if (selectNo == 4) {
				System.out.println(" 나눌 값");
				double di = Double.parseDouble(sc.nextLine());
				calculator.division();
			} else if (selectNo == 5) {
				System.out.println(" 종료하겠습니다.");
				System.exit(0);
				
			}
		}

	}

}
