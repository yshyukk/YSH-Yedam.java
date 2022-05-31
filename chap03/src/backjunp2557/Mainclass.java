package backjunp2557;

import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n;
		int x;
		int num;	//입력변수
		int i=1;	//반복횟수
			
		n = scan.nextInt();
		x = scan.nextInt();
		do {
			num = scan.nextInt();
			if(num < x ) {
				System.out.println(num + "");
			}
			i++;
		}while(i<n);
	}

}
