package com.yedam.java.ch1002;

public class MainTest {

	public static void main(String[] args) {
		try {
			// 원래 실행하고자 한코드
		} catch (Exception e) {
			// 예외가 발생한 경우 처리 코드
		} finally {
			// 정상적으로 실행하든 예외가 발생했든 반드시 실행되어야하는 코드

		}
		String data1 = null;
		String data2 = null;

		try {
			int value1 = Integer.parseInt(data1);

			data1 = args[0];
			data2 = args[1];

		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("실행 값의 수가 부족합니다.");
			return; // 메소드 어디든 return을 사용 할 수 있음. return을 사용하면 메소드 종료.
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식에 맞춰 입력해주세요");
			return;
		} catch (Exception e) {
			System.out.println("기타");
			return;
		} finally { // catch구문에서 종료했더라도 실행됨.
			System.out.println("필수 구문");

		}
		System.out.println("메인 메소드 종료");
		
		try {
			findClass();	//메인메서드에 던지지말고 Try Catch구문으로!
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String");
	}
}
