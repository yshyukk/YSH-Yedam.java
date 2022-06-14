package com.yedam.java.lifofifo;

import java.util.Stack;

public class LifoTest {

	public static void main(String[] args) {
		Stack<Integer> box = new Stack<>();
		
		box.push(100);
		box.push(50);
		box.push(500);
		box.push(10);

		while(!box.isEmpty()) {
			int value = box.pop();
			System.out.println("\tbox 값 : " + box.size());
			System.out.println("꺼내온 값 : " + value);
			
	/*pop으로 값을 꺼내올 때 get과 remove가 같이 작동한다고 생각.
		List, set, map collection에서는 값을 찾아서 검색해서 반환하지만
		Stack은 진짜 그 값을 꺼내서 주는 느낌. 그래서 pop으로 값을 꺼내면 값자체가 이동해버리기 때문에
		한번 끄집어 내버리면 그 값이 있는 객체 내에서는 값이 없어짐. (재사용 불가)
		*/	
		}
	}

}
