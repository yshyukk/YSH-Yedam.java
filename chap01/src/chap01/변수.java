package chap01;
/*	변수의 타입(유형)
 * 	변수 = 메모리의 저장위치, 값을 저장하는 공간
 *  유형 = 메모리에 값을 저장하는 형식(구조와 크기가 다름)
 *  
 *           1      2	   4     8
 * 숫자 정수 short < byte < int < long 	   
 * 	   실수 float < double  유효자릿수 정밀도 ->0.12*10^5
 * 
 * 문자	한글자	char	<= 'a''가'
 * 		단어		string	<= "홍길동"
 * 불린형 boolean			<- ture, false 
 * 날짜
 */

public class 변수 {

	public static void main(String[] args) {
		int KorScore = 129;			//상수값의 기본값은 int
		int int2 = 0b111111;
		int int8 = 017;
		int int16 = 0x7F;
		
		
		long rich = 2200000000l;	//상수값 long을 쓰려면 접미어 L or l
		float avg = 84.123456789f;
		double totalAvg = 84.7123456789;

		
		System.out.println("int2= \n\t\t \\" + int2 + "\\");
		System.out.println("int8=" + int8);
		System.out.println("int16=" + int16);
		boolean passYn = true;
		
		int k = 50, e= 50, m = 50;
		boolean fail = k>50 && e>50 && m>50;
		System.out.println("fail = " +fail);
		
		int engScore = 10;	// 변수선언, 초기화
		int mathScore;		// 변수선언
		mathScore = 100;	// 초기화
 		
		System.out.println(avg);
		System.out.println(totalAvg);
		System.out.println(engScore);
		
		char grade = 44033;	// 문자는 ''
		String grade2 = "A+";// 문자열은 ""
		
		System.out.println("grade = " + grade); //
	}

}
