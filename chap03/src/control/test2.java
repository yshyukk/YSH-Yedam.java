package control;

public class test2 {

	public static void main(String[] args) {
			test333();
	}
	public static void test333(){
	
		for(int i=0; i<10; i++) {			// i는 별개수 카운팅 하는 변수를 변화시키기 위한 변수
			for(int a=0; a < i*2; a++) {		// a는 별개수를 카운팅하기 위한 변수
				System.out.print("*");
				
			}
			System.out.println();
			
		}
				
	}
}
