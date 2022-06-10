package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		//List<Integer> list = new ArrayList<>();
		List<String> list = new Vector<>();
		
		
			
			list.add("Java");
			list.add("JDBC");
			list.add("Servlet/JSP");
			list.add(2,"Database"); //<--- 2 : index 2번에 넣어라.
			list.add("iBATIS");
			
			System.out.println("총 객체 수 : " + list.size());
			System.out.println();
			
			
			String skill = list.get(2); //list의 index 2번의 값을 가져와라.
			System.out.println("2 : " +skill);
			System.out.println();
			
			// list에 들어있는 내용 보기
			for(int i=0; i<list.size(); i++) {
				System.out.println(i + " : " + list.get(i));
			}
			
			//list의 인덱스 2번의 값과 IBATIS 삭제
			System.out.println();
			list.remove(2);
			list.remove(2); //위에서 2번index 값인 Servlet/JSP가삭제되면 -> 3번index 값이 2번으로 당겨짐.
			list.remove("IBATIS");
			
			System.out.println();
			for(String data : list) {
				System.out.println(data);
			}
			/*
		ThreadA thA = new ThreadA();
		thA.setList(list);
		thA.start();
		
		ThreadA thB = new ThreadA();
		thB.setList(list);
		thB.start();
	*/		
		}
	
	
}	


