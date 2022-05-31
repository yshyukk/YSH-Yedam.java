package com.yedam.java.test;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		StudentSystem test = new StudentSystem();

		boolean run = true;
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("1.학생 수 입력 | 2.학생정보 등록 | 3.학생정보 전체조회 | 4. 학생정보 분석 | 5.종료");
			System.out.println("선택 >");

			int selNum = sc.nextInt();
			if (selNum == 1) {
				System.out.println("학생 수 > ");
				int count = sc.nextInt();
				test.setStCount(count);
				System.out.println();
			} else if (selNum == 2) {
				System.out.println("학번 : " + "이름 : " + "점수 : ");
				int stnum = sc.nextInt();
				String stname = sc.next();
				int scores = sc.nextInt();

				test.putStudent(stnum, stname, scores);
			} else if (selNum == 3) {
				System.out.println();
				test.studentList();
			} else if (selNum == 4) {
				Student max = test.getMax();
				Student maxnu = test.getStNum();
				System.out.println("최고 점수 : " + max.getScores() + ", 학번 : " + max.getStNum());
				System.out.printf("학생 점수 중 1번 학생을 제외한 평균 점수는 " + "%.2f 입니다.\n", test.Avg());
			} else if (selNum == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}

		}

	}

}
