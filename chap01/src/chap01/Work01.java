package chap01;

public class Work01 {

	public static void main(String[] args) {
	
		Work();

	}
	
	public static void Work() {
		char grade 	= '상';
		String schoolName = "예담";
		int score	= 85;
		double average	= 4.235;
		int	flage	= 0b1000000;
		char firstChar	= '\uAC00';
		int secondChar = 0xAC01;
		int salary	= 1_000_000;
		boolean useYn	= true;
		
		System.out.printf("grade =" +grade + "\t, schoolName=" +schoolName + "\t\t, score="+score);
		
	}
}
