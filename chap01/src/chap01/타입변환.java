package chap01;
/*
 * 데이터타입을 다른 탕비으로 변환
 * 강제형변환
 * 자동형변환
 * 
 * 
 * String <-----> 기본데이터형 (int, double)
 */
public class 타입변환 {

	
	public static void main(String[] args) {
		//자동
		int a = 100;
		long b = a;

		//강제
		long c = 100;
		int d = (int)c;
		
		//자동
		double e = c;
		
		//강제
		double f = 5.2;
		long g = (long) f;
		System.out.println("g= " + g);
		
		double h = (double) 10 / 3.3;
		System.out.println("h= "+ h);
		
		
		// int -> string
		int i = 100;
		String j =String.valueOf(i);
		
		//String -> int
		String k = "100";
		int l = Integer.parseInt(k);
	

	}

}
