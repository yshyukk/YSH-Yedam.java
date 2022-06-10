package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		//set.add(new String("Java"));
		set.add("IBATIS");
		
		System.out.println("총 객체 수 : " + set.size());
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		//다음에 값이 있는지 여부 -> 안에 내용 출력 (iterator가 가져오는 순서대로 출력됨)
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println();
		
		set.remove("JDBC");
		set.remove("IBATIS");
	
		for(String data : set) {
			System.out.println(data);
		}
		System.out.println();
		
		set.clear();
		//isEmpty() : 컬렉션이 비어있는지
		if(set.isEmpty()) {
			System.out.println("비어있음");
		}
	}
	

}
