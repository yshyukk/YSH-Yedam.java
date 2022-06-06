package com.yedam.java.test;

public class Student {

	private int stnum;
	private String stname;
	private int scores;

	// 생성자
	public Student() {

	}

	public Student(int stnum, String stname, int score) {
		this.stnum = stnum;
		this.stname = stname;
		this.scores = scores;
	}
	// 메서드
	public void setStNum(int stnum) {
		this.stnum = stnum;
	}
	public void setStName(String stname) {
		this.stname = stname;
	}
	public void setScore(int score) {
		this.scores =score;
	}

	public int getStNum() {	// 학번
		return  stnum;
	}

	public String getStName() { // 학생 이름
		return  stname;
	
	}
	public int getScores() { // 점수
		return  scores;
	}
	public void showInfo() {
		System.out.println(stnum + " : " + stname + " : " + scores);
	}
}