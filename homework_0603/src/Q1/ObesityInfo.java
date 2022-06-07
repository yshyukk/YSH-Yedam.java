package Q1;

public class ObesityInfo extends StandardWeightInfo {
	// 필드
	double obesity;

	// 생성자
	public ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
		
		this.obesity = (weight / getStandardWeight()) * 100;
	}

	// 메서드
	@Override
	public void getInformation() {

		String ob;
		if (obesity < 110) {
			ob = "저체중";
			System.out.printf(name + "님의 신장 " + height + ", 몸무게 " + weight + ", " + ob + "입니다.");

		} else if (110 <= obesity && obesity < 120) {
			ob = "과체중";
			System.out.printf(name + "님의 신장 " + height + ", 몸무게 " + weight + ", " + ob + "입니다.");

		} else if (120 <= obesity) {
			ob = "비만";
			System.out.printf(name + "님의 신장 " + height + ", 몸무게 " + weight + ", " + ob + "입니다.");
		}

	}

	public double getObesity() {
		obesity = (weight / getStandardWeight()) * 100;
		return obesity;
	}

}
