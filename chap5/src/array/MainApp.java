package array;

import java.util.Scanner;

public class MainApp {

	// 배열선언
	// 모든 요소가 0으로 초기화
	static int score[] = new int[10];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//배열생성과 초기화
		init();
		//반복문
			//메뉴출력
		while (true) {
			System.out.println("1.전체출력 2.최솟값 3.최댓값 4.평균 5.종료");
			System.out.println("선택> ");
			
			int menu = 0;
			menu = scan.nextInt();

			switch(menu) {
			case 1:
				printAll();
				break;
			case 2:  
				findMin();
				break;
			case 3:
				findMax();
				break;
			case 4:
				findAvg();
				break;
			case 5:
				break;
			default: // switch문 안에서 break는 switch문만 나감. 따라서 while문까지 종료하는 조건문 따로 작성.
				System.out.println("1~5를 입력하세요");
			}
			if( menu==5 ) break; // 5번 입력했을때 프로그램 종료하려면 밖에서 따로 조건!
			}

		}
		

	
	public static void init() {
		for (int i = 0; i < 10; i++) {
			score[i] = scan.nextInt();
			// System.out.println(score[i]);
		}
	
}
	
	public static void printAll() {
		for (int i = 0; i < 10; i++) {
			System.out.println(score[i]);
		}

	}

	public static void findMin() {
		// 2번학생의 점수 (0번부터 시작이니까 2번째학생 i=1)
		int min = score[0];
		for (int i = 1; i < 10; i++) {
			if (min > score[i]) {
				min = score[i];
			}
		}
		System.out.println(min);
	}

	public static void findAvg() {

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = score[i] + sum;
		}
		double avg = sum / 10.0;
		System.out.println(avg);
	}

	public static void findMax() {
		int max = score[0];
		for (int i = 1; i < 10; i++) {
			if (max < score[i]) {
				max = score[i];
			}
		}

		System.out.println(max);
	}

}
