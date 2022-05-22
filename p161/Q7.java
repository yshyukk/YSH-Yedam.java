package p161;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 |3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.println("선택> ");
			
			int menuNum = Integer.parseInt(scan.nextLine());
			
			switch (menuNum) {
			case 1:
				System.out.println("예금액> ");
				balance += Integer.parseInt(scan.nextLine());
				break;
			case 2:
				System.out.print("출금액> ");
				balance -= Integer.parseInt(scan.nextLine());
				break;
			case 3:
				System.out.println("잔고> ");
				System.out.println(balance);
				break;
			}
			System.out.println();
		} 
		System.out.println("프로그램 종료");
	}

}
