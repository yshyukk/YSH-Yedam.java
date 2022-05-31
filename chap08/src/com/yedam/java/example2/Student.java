package com.yedam.java.example2;

public class Student {
//필드
	private int id;
	private String name;
	private int score;
	
//생성자
	public Student() {}
	
	public Student(int id, String name, int score ) {
		this.id = id;
		this.name = name;
		this.score =score;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	public void showInfo() {
		System.out.println("학번 : " + id + ", 이름 :  " + name + ", 점수 : " + score);
	}
	
	
//메서드
}
