package Q1;

public class StandardWeightInfo extends Human {
	// 필드
	double stweight;

	// 생성자
	public StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
		this.stweight = (double) (height - 100) * 0.9;
		;
	}

	// 메서드

	@Override
	public void getInformation() {

		System.out.printf(name + "님의 신장 " + height + ", 몸무게 " + weight + ", 표준체중 %.1f 입니다.\n", stweight);

	}

	public double getStandardWeight() {

		return stweight;
	}
}
