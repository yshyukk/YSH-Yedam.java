package Memory;

public class EqualTest {

	public static void main(String[] args) {
		
		int[] a = new int[5];
		int[] b = a;				//얕은복사 = 하나의 객체를 참조.주소만 복사
		int[] c = new int[a.length];
		System.arraycopy(a, 0, c, 0, a.length);	// 깊은 복사 = 서로 별개의 객체가 생성됨.		
		
		
		b[0] = 100;
		
		System.out.println(a[0]);

		
		//스트링
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 = "hi";
		String s4 = "hi";
		System.out.println(s3 == s4);
	}
	

}
