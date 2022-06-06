package Q1;

public class Q1Test {

	public static void main(String[] args) {

		StandardWeightInfo st = new StandardWeightInfo("홍길동", 168, 45);
		st.getInformation();

		ObesityInfo obes = new ObesityInfo("박둘이", 168, 90);
		obes.getInformation();

	}

}
