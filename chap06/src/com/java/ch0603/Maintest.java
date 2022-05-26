package com.java.ch0603;

import java.util.Scanner;

public class Maintest {

	public static void main(String[] args) {

		Program program = new Program();
		Scanner sc = new Scanner(System.in);

		
		boolean run = true;
		int selectNo = 0;

		while (run) {

			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			selectNo = Integer.parseInt(sc.nextLine());

			if (selectNo == 1) {
				System.out.println("학생 수> ");
				
				int student = Integer.parseInt(sc.nextLine());
				program.setStudentNum(student);

			} else if (selectNo == 2) {
				System.out.println("점수> ");
				int score = Integer.parseInt(sc.nextLine());
				program.setStudentScore(score);
				

			} else if (selectNo == 3) {
				program.printScores();
			} else if (selectNo == 4) {
				program.printResult();
				
			} else if (selectNo == 5) {

			}

		}

	}

}
