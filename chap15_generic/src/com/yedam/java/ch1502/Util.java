package com.yedam.java.ch1502;

public class Util {
	// 숫자class의 최상위 class는 Number <== Number만 사용하겠다.
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
}
