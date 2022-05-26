package array;

public class array2 {

	public static void main(String[] args) {
		int[] intAry = new int[2];
		for (int i = 0; i < intAry.length; i++) { // index는 배열을 길이를 넘을 수 없음. == i < intAry.length;
			System.out.println("intAry[ " + i + "]" + intAry[i]);
		}

		int[][] intAry2 = new int[3][2]; // new int[int배열을 몇개 가지냐][그 int 배열은 몇개의 int를 가지냐]
											// int가 [2]인 배열이 총 3개 존재하는 2차원 배열
											// 2개의 인덱스가 필요
		for (int i = 0; i < intAry2.length; i++) {
			int[] tempAry = intAry2[i];
			for (int j = 0; j < tempAry.length; j++) {
				System.out.println("tempAry[" + j + "]: " + tempAry[j]);
			}
		}

		for (int i = 0; i < intAry2.length; i++) {
			for (int j = 0; j < intAry2[i].length; j++) {
				System.out.println("intAry2[" + i + "[" + i + "]:" + intAry2[i][j]);
			}
		}

		System.out.println();
		int[][] intAry3 = new int[2][]; // 2차원 배열의 크기가 2라는 것만 알고있을 때
		intAry3[0] = new int[3];
		intAry3[1] = new int[5];
		// 2차원 배열은 배열의 크기가 고정X이므로
		for (int i = 0; i < intAry3.length; i++) { // for문 사용할 때는 length사용. 임의로 값 고정X
			for (int j = 0; j < intAry3[i].length; j++) {
				System.out.println("intAry3[" + i + "][" + j + "]:" + intAry3[i][j]);
			}
		}

		System.out.println();
		int[][] javaScores = { { 95, 80 }, { 92, 96, 80 } };

		for (int i = 0; i < javaScores.length; i++) {
			for (int j = 0; j < javaScores[i].length; j++) {
				System.out.print(javaScores[i][j] + " ");
			}

		}

		// 향상된 for문 ( index에서 값을 가져오지 않음) <== 단순히 전체 값을 출력할때만 사용
		for (int[] tempAry : javaScores) { // javaScores의 배열의 값을 하나하나 임시변수(=tempAry)로
			for (int temp : tempAry) {
				System.out.println(temp);
			}
		}
	}
}
