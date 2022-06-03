package com.yedam.java.ch1102;

public class StringTest2 {

	public static void main(String[] args) {
		// toLowerCase() & toUpperCase()
		String str1 = "Java Programing";
		String str2 = "JAVA PROGRAMING";
		if (str1.equals(str2)) { // 대소문자 구분하므로 대소문자까지 같아야 같다고 인식.
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		if (val1.equals(val2)) {
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		if (str1.equalsIgnoreCase(str2)) { // 대소문자 구분 없이 뜻이 같은 것을 인식.
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}

		// trim() : 앞뒤 공백 삭제
		String subject = "         자바    프로그래밍                   ";
		String newData = subject.trim();
		System.out.println(newData); // <--- 가운데 공백은 X
		
		System.out.println();
		String result1 = newData.substring(0, 2);
		String result2 = newData.substring(newData.indexOf("프로그래밍")); 
		//indexOf => 프로그래밍의 첫글자의 위치를 출력 == 따라서 substring의 beginIndex로 사용.
		System.out.println(result1 + " " + result2);
		
		//valueOf : 기본타입을 String으로 변환
		//정석
		String value1 = String.valueOf(10);
		String Value2 = String.valueOf(10.5);
		String Value3 = String.valueOf(true);
		
		//팁
		String value4 = "" + 100;
	}

}
