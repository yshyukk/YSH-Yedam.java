package control;

import java.util.Scanner;

public class ControlMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 				// 키보드에서 입력하는(System.in)값을 scan에 넣겠다.
		
		int score;						// {}안에서 변수선언하면 {}안에서만 변수적용됨.
		String grade;
		
		
		do { // 조건이 맞을동안은 계속실행
			 
			score = Integer.parseInt(scan.nextLine()); // 한 문장 줄래?<--엔터키 치기 전까지 내놔
			if(score ==0) {
					break; //반복문을 빠져나감
			}
			
			// 등급계산 조건문
			if (score >= 90) {
				grade = "A등급";
			} else if (score >= 80) {
				grade = "B등급";
			} else if (score >= 70) {
				grade = "C등급";

			} else {
				grade = "D등급";  //<-- 입력되는 값이 없을때 출력되는 값.
			}
			// 등급 결과 출력
			System.out.printf("%d 성적은 %s입니다.", score, grade); // %d : 숫자 , %s : 문자출력
		} while (score !=0); // !=0 <--- 0이 나올때까지 반복하라는 의미.
		System.out.println("프로그램 종료");// 종료될때 ()안 내용을 출력해라.
		

	}
}
