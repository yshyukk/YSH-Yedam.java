package com.yedam.java.ch0604_01;

public class Calculator {
	int[] numList; // 숫자 입력받을 배열 선언
	int index;

	Calculator() {
		index = -1; // 가장 최근에 index에 넣은 값.
	}

	// 1. 갯수 입력
	void setArrayNumSize(int Size) {
		numList = new int[Size];
	}
	// 2. 숫자 입력

	void setNum(int num) {
		if (index+1 < numList.length) {  // index -1 이라서 +1해줌
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더 이상 입력할 수 없습니다.");
		}
	}

	// 3. 더하기 #
	void plus() {
		if (isExcuted()) {
			int sum = 0;
			for (int i = 0; i <= index; i++) {
				sum += numList[i];
			}
			System.out.println("더한 결과 : " + sum);
		}
	}

	// 4. 빼기
	void subtracted() {
		if (isExcuted()) {
			int sub = 0;
			for (int i = 0; i <= index; i++) {
				sub -= numList[i];
			}
			System.out.println("뺀 결과 : " + sub);
		}
	}
	// 5. 곱하기

	void multiplicated() {
		if (isExcuted()) {
			int multi = 1;
			for (int i = 0; i <= index; i++) {
				multi *= numList[i];
			}
			System.out.println("곱한 결과 : " + multi);
		}
	}

	// 6. 나누기
	void division() {
		if (isExcuted()) {
			double div = 1;
			for (int i = 0; i <= index; i++) {
				div /= (double) numList[i];
			}
			System.out.println("곱한 결과 : " + div);

		}
	}

	// 조건 체크 메서드 <-- 배열에 들어가 있는 값이 2개 이상인지 확인
	boolean isExcuted() {
		if ((index + 1) >= 2) {
			return true;
		} else
			System.out.println("숫자를 더 입력 해 주세요.");
		return false;
	}

}
