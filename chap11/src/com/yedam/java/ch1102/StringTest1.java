package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {

	public static void main(String[] args) {

		// byte -> String
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4); // 6 : 74의 인덱스 위치, 4 : 4개
		System.out.println(str2);

		System.out.println();

		// String -> byte -> String
		String str = "안녕하세요";
		// string -> byte
		byte[] bytes1 = str.getBytes();
		System.out.println(bytes1);
		// byte -> String
		String strs1 = new String(bytes1);
		System.out.println(strs1);

		try {
			byte[] bytes2 = str.getBytes("EUC-KR"); // <--"EUC-KR이라는 것을 기반으로 인코딩 하겠다"라고 자바가 알고있다는 전제로 사용,
			System.out.println(bytes2);
			String strs2 = new String(bytes2, "EUC-KR");
			System.out.println(str2);

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		System.out.println(); // console창 결과출력에 공백
		// CharAt : 한 글자만 가져오기
		String ssn = "010621-1230123";
		char gender = ssn.charAt(7); // <--- 원본은 건드리지 않고 복사해옴.

		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;

		}
		for (int i = 0; i < ssn.length(); i++) {
			System.out.println(ssn.charAt(i)); // <-- charAt을 이용해 하나하나의 값을 출력할 수 있음.
		}

		System.out.println(); // console창 결과출력에 공백
		// equals
		String val1 = "신민철"; // 처음에 프로젝트에 신민철이라는 인스턴스를 생성
		String val2 = "신민철"; // 두번째 신민철은 new연산자 없이 선언하면 처음생성된 신민철이라는 인스턴스를 사용
		String val3 = new String("신민철"); // 새로운 인스턴스가 필요할때는 무조건 new연산자를 사용해야함.

		if (val1.equals(val2)) { // equals는 값만 비교
			System.out.println("val1과 val2는 값이 같습니다.");
		} else {
			System.out.println("val1과 val2는 값이 다릅니다.");
		}
		if (val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else {
			System.out.println("val1과 val3는 값이 다릅니다.");
		}
		System.out.println();
		if (val1 == val2) { // == 은 인스턴스비교
			System.out.println("vall과 val2는 같은 인스턴스입니다.");
		} else {
			System.out.println("vall과 val2는 같은 인스턴스입니다.\")");
		}
		if (val1 == val3) {
			System.out.println("vall과 val3는 같은 인스턴스입니다.");
		} else {
			System.out.println("vall과 val3는 다른 인스턴스입니다.");
			System.out.println();
		}

		// indexOf : 이 문장 안에 내가 찾고자 하는 단어가 있는지 여부만 확인하는데 주로 사용됨.
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		System.out.println();
		// 찾는값이 없다면 -1을 출력함.

		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련 없는 책");
			System.out.println();
		}
		//substring(int beginIndex) : beginIndex위치에서 끝까지 잘라낸 새로운 문자열을 리턴
		//정확한 위치를 모를 때
		String result1 = subject.substring(subject.indexOf("프로그래밍")); //indexOf를 이용해 substring의 위치를 설정.
		System.out.println(result1); 
		
		String ssn1 = "880815-1234567";
		System.out.println("생년월일 : " + ssn1.substring(0,6)); // <--우리가 원하는 값은 0~5지만, 시작하는 인덱스보다 하나 앞에 끊어버리기 때문에 6
		System.out.println("개별정보 : " + ssn1.substring(7));
		
		//length
		String[] temp = {"1","2"};
		int val = temp.length; // <<여기서 length는 필드
		
		System.out.println(ssn1.length()); //<-- 여기서는 메서드이므로 ()!
		
		//replace(바꾸는 것, 이걸로 바꿔);
		String oldStr = "Java 프로그래밍";
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr + " -> " + newStr);
		
	}

}
