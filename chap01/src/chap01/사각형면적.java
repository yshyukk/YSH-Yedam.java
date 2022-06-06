package chap01;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("가로입력");
		int w = Integer.parseInt( scan.nextLine());
		
		System.out.println("세로입력");
		int h = Integer.parseInt(scan.nextLine());
		
		int area = w * h;
		System.out.println("면적=" + area);
	}

}
