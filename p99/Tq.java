package p99;

import java.util.Scanner;

public class Tq {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double w, h, area;
		
		System.out.println("가로: ");
		w = Double.parseDouble(scan.nextLine());
		
		System.out.println("세로: ");
		h = Double.parseDouble(scan.nextLine());
		
		area = ( w * h ) / 2;
		System.out.printf("가로: %2.1f \n세로: %2.1f \n면적: %3.2f", w,h,area);
		
		

	}

}
