import java.util.Random;
import java.util.Scanner;

public class asjkdljzskldjkl {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Guessgame();
		Regame();
	}

	public static void Guessgame() {

		int Nu[] = new int[10]; // 매 기회마다 선택하는 수

		int Rd = (int) (Math.random() * 99) + 1; // 맞춰야 하는 랜덤숫자
		Scanner scan = new Scanner(System.in);
		int count = 0; // 기회

		System.out.println("숫자맞추기 게임");
		System.out.println("1 ~ 100까지 숫자중 하나를 맞춰보세요.");
		System.out.println("기회는 단 10번!!!");
		if (Rd % 2 == 0) {
			System.out.println("HINT : 짝수입니다.");
		} else if (Rd % 2 != 0) {
			System.out.println("HINT : 홀수입니다.");
		}

		for (int i = 0; i < 10; i++) { // 기회는 총 10번이므로 10회 반복

			count++; // 기회를 1회씩 증가
			Nu[i] = scan.nextInt();
			if (Rd < Nu[i]) {

				System.out.println("#### DOWN !!! ####");
				System.out.println("남은 기회는?? = " + (10 - count));

			} else if (Rd > Nu[i]) {
				System.out.println("##### UP !!! ####");
				System.out.println("남은 기회는?? = " + (10 - count));

			} else if (Rd == Nu[i]) {

				System.out.println("#### 축하합니다. 성공입니다 #####");
				System.out.println((10 - i) + "번 만에 맞추셨네요!?");
				break;

			}
			if (count == 10) {
				System.out.println("#### 기회를 모두 사용하셨습니다. 다음기회에 ...####");
				break;

			}

		}

		String yes = "Y";
		String no = "N";
		char Again = ' ';

		System.out.println("게임을 다시 진행 하시겠습니까?    " + yes + "/" + no);

		Again = scan.next().charAt(0);
		{
			if (Again == 'Y') {
				Regame();

			} else {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			}

		}

	}

	public static void Regame() {

		Guessgame();

	}

}

