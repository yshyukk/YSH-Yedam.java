package p99;

import java.util.Scanner;

public class q3 {

	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		
		System.out.println("[필수 정보 입력]");
		
		System.out.println("1. 이름:");
		String name = scan.nextLine();
		
		System.out.println("2. 주민번호 앞 6자리:");
		String idnum = scan.nextLine();
		
		System.out.println("3. 전화번호:");
		String phnum = scan.nextLine();
		
		System.out.println("[입력한 내용]");
		
		System.out.println("1. 이름: " + name);
		System.out.println("2. 주민번호 앞 6자리: " + idnum);
	    System.out.println("3. 전화번호: "  + phnum);
	    
	
	}

}
