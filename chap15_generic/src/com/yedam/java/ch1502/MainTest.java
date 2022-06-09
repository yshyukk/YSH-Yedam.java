package com.yedam.java.ch1502;

public class MainTest {

	public static void main(String[] args) {
		//int result1 = Util.compare("홍", "김"); => Util에서 숫자만 받기로 했으니까. 사용 불가.

		int result2 = Util.compare(1, 10);
		
		int result3 = Util.compare(0.5, 5.9);
	}	

}
