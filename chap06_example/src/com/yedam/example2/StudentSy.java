package com.yedam.example2;

public class StudentSy {
	public static void main(String[] grgs) {
		
		student yoon = new student("윤상혁");
		System.out.println(student.getSerialNum());
		System.out.println(yoon.getName() + "의 학번 : " + yoon.getSerialNum());
		
		
		student son = new student("손흥민");
		System.out.println(student.getSerialNum());
		System.out.println(son.getName() + "의 학번 : " + son.getSerialNum());
		System.out.println(yoon.getName() + "의 학번 : " + yoon.getSerialNum());
		
	}
	
} 


