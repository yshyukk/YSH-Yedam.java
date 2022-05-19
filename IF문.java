package p161;

import java.util.Scanner;

public class IF문 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int menu = 0;
		int balance = 0;
		int input = 0;
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 |4. 종료 ");
			System.out.println("-----------------------------");
			System.out.println("선택>");
			menu = scan.nextInt();
				if( menu ==1 ) {
					input = scan.nextInt();
				    balance = balance + input ;
					System.out.println("선택> "+menu);
					System.out.println("예금액> "+balance);
						
				}else if (menu ==2 ) {
					input = scan.nextInt();
				    balance = balance - input ;
					System.out.println("선택> " +menu);
					System.out.println("출금액> " +balance);
				
				}else if (menu ==3 ) {
					System.out.println("선택> " +menu);
					System.out.println("잔고액> " +balance);
				
				}else {
					System.out.println("프로그램 종료");
					break;
				} 
		}
	}

}
