
public class asdasd {
	int[] scores;
	int index;

	asdasd() {
		index = -1; // 가장 최근 입력 값
	}

	// 학생 수 입력
	void setStNum(int st) {
		scores = new int[st];
	}

	// 학생 점수 입력
	void setStSco(int sc) {
		scores[++index] = sc;
	}

	// 학생 점수 전체 조회
	void printScores() {
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "]" + scores[i]);
		}
	}

	int getMaxScore() { // 최댓값 출력
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {

			if (max < scores[i]) {
				max = scores[i];
			}

		}
		return max;
	}

	int getMinScore() { // 최솟값 출력
		int min = scores[0];
		for (int i = 0; i < scores.length; i++) {

			if (min > scores[i]) {
				min = scores[i];
			}
		}
		return min;

	}

	double getAvgScore() { // 평균

		int min = scores[0];
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {

			if (min > scores[i]) {
				min = scores[i];
			} else if (max < scores[i]) {
				max = scores[i];
			}
		}

		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return (double) (sum - (max + min)) / (scores.length - 2);

	}

	void printResult() {

		System.out.println("최고 점수 : " + getMaxScore());
		System.out.println("최저 점수 : " + getMinScore());
		System.out.printf("평균 점수 : %.2f\n", getAvgScore());
	}
}

