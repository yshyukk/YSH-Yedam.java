package com.yedam.java.ch1001;

public class MainTest {

	public static void main(String[] args) {

		// 실행예외 -> 문법적으로는 문제가 없고 실제 실행 시 발생하는 예외, 정상적으로 값이 들어오면 실행됨.

		// NullPointException
		String data = null; // null을 가지는 것 자체는 오류X
		if (data != null) {
			System.out.println(data.toString()); // <-- 예외처리 , deadcode = 어떤 경우에도 실행되지 않는 코드
		}
		// null은 비어있는 공간을 뜻하므로 출력할 값자체 (실행할 주체)가 없음.

		// ArrayIndexOutOfBoundsException
		if (args.length >= 2) {	//<--예외처리

			String data1 = args[0];
			String data2 = args[1];

			System.out.println("args[0] " + data1);
			System.out.println("args[1] " + data2);
			
		}
		// NumberFormatException
		
		/*String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		
		int result = value1 + value2;
		*/
		
		//CalssCastEsception cast:타입변환
		// 뭐가 뭐로 변환할 수 없는지 확인
		
		
		changeDog(new Dog());
		changeDog(new Cat());
		
	}

	public static void changeDog(Animal animal){
		if(animal instanceof Dog) { //타입변환 할때는 항상 instanceof
		Dog dog = (Dog) animal;
		}
	}
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}