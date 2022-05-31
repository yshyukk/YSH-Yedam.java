package com.yedam.java.test;

public class StudentSystem {
	private Student[] list;
	private int index;

	public StudentSystem() {
		index = -1;
	}

	// 1. 학생 수 입력
	public void setStCount(int count) {
		list = new Student[count];
	}

	// 2. 학생정보 등록
	public void putStudent(int stnum, String stname, int scores) {
		Student student = new Student(); // 들어올 값 담기 위한 변수
		student.setStNum(stnum);
		student.setStName(stname);
		student.setScore(scores);

		list[++index] = student;
	}

	// 3. 학생정보 전체조회
	public void studentList() {
		for (int i = 0; i <= index; i++) {
			Student student = list[i];
			// System.out.println(product.getName() + ":" + product.getPrice());
			System.out.println("학번 : " + student.getStNum() + ", 이름 :" + student.getStName() + ", 점수 : " + student.getScores() + ":");
		}
	}

	// 4. 학생정보 분석 (학번 출력)
	public Student getStNum() {
		Student num = list[0];
		System.out.println("학번 >");
		return num;
	}

	// 4. 학생정보 분석 (점수출력)
	public Student getScores() {
		Student scores = list[0];
		System.out.println("학점 >");
		return scores;

	}

	// 5. 분석 (최고점)
	public Student getMax() {
		Student max = list[0];
		for (int i = 1; i <= index; i++) {
			if (max.getScores() < list[i].getScores()) {
				max = list[i];
			}
		}
		return max;

	}

	// 5. 분석 (최저점)
	public Student getMin() {
		Student min = list[0];
		for (int i = 1; i <= index; i++) {
			if (min.getScores() < list[i].getScores()) {
				min = list[i];
			}
		}
		return min;
	}

	// 5. 분석 (평균 - 1번학생 제외)
	double Avg() {

		int sum = 0;
		for (int i = 1; i < list.length; i++) {
			sum += list[i].getScores();
		}
		return sum / list.length;

	}

}
