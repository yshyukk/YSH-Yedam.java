package p99;

import java.util.Scanner;

public class q2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 수:");
		String strNum1 = scan.nextLine();
		
		
		System.out.println("두번째 수:");
		String strNum2 = scan.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈결과:" + result);
	}

}
