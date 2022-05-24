package com.yedam.example2;

public class student {	// 학점계산
	//필드
	
	private static int serialNum = 1000; // 정적필드(static)
	
	private int studentId; //학번
	private String name;
	
	//생성자
	public student(String name) {
		serialNum++;
		this.studentId = serialNum;
		this.name = name;
		
	}
	
	//메소드
	public static int getSerialNum() {	//getter는 get필드명
		return serialNum;
		
	}
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	
}
