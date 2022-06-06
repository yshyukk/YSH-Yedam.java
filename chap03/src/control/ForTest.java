package control;

public class ForTest {

	public static void main(String[] args) {
		test1();
	}
	public static void test1() {
		
		for(int i=0;i<10;i++) {			
			for(int a=0; a < i*2; a++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
