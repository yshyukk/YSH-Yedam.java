package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat todayNow = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String result = todayNow.format(now);
		System.out.println(result);
		
	
	}
}
