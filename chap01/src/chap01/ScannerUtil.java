package chap01;

import java.util.Scanner;

public class ScannerUtil {

	public static void main(String[] args) {
		
		String name, job;
		int age;
		
		//문자열 입력
		Scanner scan = new Scanner(System.in);
		
		//프롬프트 출력
		System.out.println("이름입력:");
		//문자열 입력받아서 변수에 저장
		name = scan.nextLine();	//엔터키 이전까지 입력
		
		//프롬프트 출력
		System.out.println("직업입력:");
		//문자열 입력
		job = scan.nextLine();
		//프롬프트 출력
		System.out.println("나이입력:");
		//문자열 입력
		age = Integer.parseInt( scan.nextLine() );
				
		
		//입력받은 문자열을 출력
		System.out.println("이름=" +name);
		System.out.println("직업=" +job);
		System.out.println("나이=" +age);

	}

}
