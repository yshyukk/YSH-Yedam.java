package com.java.ch0603;
//1.학생수 입력 ->>배열 초기화

//2.점수입력
//3.점수 리스트 출력
//4.분석 - 최고점수, 평균점수

public class Program {
	// 필드
	int[] scores; // 배열 선언
	int index;

	// 생성자
	Program() {
		index = -1;
	}

	// 메소드
	// 1. 학생수 입력
	void setStudentNum(int student) {
		scores = new int[student];
	}

	// 점수 리스트 출력

	void printScores() {
		for (int i = 0; i < scores.length; i++)
			System.out.println("scores[ " + i + scores[i]);

	}

	void setStudentScore(int score) {
		index++;
		scores[index] = score;
		System.out.println("score[ " + index + scores[index]);
	}

	int getMaxScore() {
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			int temp = scores[i];
			if (max < temp) {
				max = temp;
			}

		}
		return max;
	}

	// 평균 점수
	double getAvgScore() {
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return (double) sum / scores.length;
	}
	//분석
	void printResult() {
		System.out.println("최고 점수 : " + getMaxScore());
		System.out.println("평균 점수 : " + getAvgScore());
	}
}
