package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 숫자맞추기 게임
 * 
 */
public class GuessNumber {

	public static void main(String[] args) throws FileNotFoundException {

		// Ex1()
		// for1();
		// for2();
		// gugudan1();
		// findMax(); //최댓값
		findMin();

	}

	public static void findMin() throws FileNotFoundException {
		// 파일에서 입력받을 것임
		Scanner scan = new Scanner(new File("score.txt"));
		int max = 0;
		int min = 0;
		// 10번을 반복 입력받아서 (for문)
		// 숫자를 입력
		// 60보다 크면 출력 (if문)
		for (int i = 1; i <= 10; i++) {

			int a = scan.nextInt();
			if ( i==1 ) {
				min = a;
			}
			if ( a < min) {
				min = a;
			}
			// 큰수보다 크면 출력
			if (a > max) {
				max = a;
			}

		}
		
		System.out.println(max);
		System.out.println(min);
	}

	// 최댓값 구하기
	public static void findMax() throws FileNotFoundException {
		// 파일에서 입력받을 것임
		Scanner scan = new Scanner(new File("score.txt"));
		int max = 0;
		// 10번을 반복 입력받아서 (for문)
		// 숫자를 입력
		// 60보다 크면 출력 (if문)
		for (int i = 1; i <= 10; i++) {

			int a = scan.nextInt();
			// 큰수보다 크면 출력
			if (a > max) {
				max = a;
				System.out.println(a);
			}
		}
	}

	// 5단출력
	public static void gugudan1() {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}

	public static void for2() {
		for (int i = 10; i <= 0; i--) {

		}
	}

	public static void for1() {
		for (int count = 1; count <= 10; count += 2) {
			System.out.println(count + "반복");
		}
	}

	public static void Ex1() {
		Scanner scan = new Scanner(System.in);

		int rand = (int) (Math.random() * 100) + 1; // 나중에 난수로 바꿀것
		int num; // 유저가 입력하는 값
		String result;
		int count = 1;

		// 반복
		do {
			count++;
			// 키보드 정수값을 읽어서 num 변수에 저장
			num = scan.nextInt();
			if (rand > num) {
				System.out.println("크다");
			} else if (rand < num) {
				System.out.println("작다");
			} else {
				System.out.println("맞다");
				break;
			}
			//// count(시도횟수)가 5회이상이면 게임종료

			if (count > 5) {
				break;
			}
		} while (true);
	}

}

// 반복
// 키보드 정수값을 읽어서 num 변수에 저장
// rand > num "크다"출력
// rand < num "작다"출력
// rand == num break
