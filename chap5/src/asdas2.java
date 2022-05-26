import java.util.Scanner;

public class asdas2 {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		asdasd Hw_calprogram = new asdasd();

		while (run) {

			System.out.println(" 1. 학생수 입력 | 2. 학생점수 등록 | 3. 학생점수 전체조회 | 4. 학생정보 분석 | 5. 종료");
			System.out.println("선택 > ");

			int selNum = Integer.parseInt(scan.nextLine());

			if (selNum == 1) {
				System.out.println("학생 수 > ");
				int stu = Integer.parseInt(scan.nextLine());
				Hw_calprogram.setStNum(stu);

			} else if (selNum == 2) {
				System.out.println(" 점수 > ");
				int score = Integer.parseInt(scan.nextLine());
				Hw_calprogram.setStSco(score);

			} else if (selNum == 3) { // 전체조회
				Hw_calprogram.printScores();

			} else if (selNum == 4) { // 분석
				Hw_calprogram.printResult();

			} else if (selNum == 5) { // 종료
				run = false;

				System.out.println("프로그램 종료");

			}

		}

	}

}

