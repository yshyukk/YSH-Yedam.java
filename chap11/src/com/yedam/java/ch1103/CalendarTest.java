package com.yedam.java.ch1103;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		//캘린더(싱글톤의 형태)는 new연산자 사용X, getInstance(정적메서드)이용해서 Instance가져와야함.
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR); //<--- Calendar의 필드를 이용!
		int month = now.get(Calendar.MONTH) +1; // Month는 0부터 시작하기 때문에 항상 +1
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		
		switch(week) {
		case Calendar.MONDAY :
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY :
			strWeek = "수";
			break;
		case Calendar.THURSDAY :
			strWeek = "목";
			break;
		case Calendar.FRIDAY :
			strWeek = "금";
			break;
		case Calendar.SATURDAY :
			strWeek = "토";
			break;
		case Calendar.SUNDAY :
			strWeek = "일";
			break;
		}
		
		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		}else {
			strAmPm = "오후";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.print(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.print(second + "초 ");
			
	}

}
