package control;

import java.util.Scanner;

/*
 * 1. 사각형 2.삼각형 0.종료
 * 
 */
public class MenuArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int menu;
		String Area;

		// 반복
		// menu 입력
		// 1이면 "사각형"출력
		// 2이면 "삼각형"출력
		// 0이면 break
		do {
			menu = Integer.parseInt(scan.nextLine());
			if (menu == 0) {
				break;
			}
			if (menu == 1) {
				Area = "사각형";
			} else if (menu == 2) {
				Area = "삼각형";
			} else {
				System.out.println("나가세요");
				Area = "니 잘못";
			}

			System.out.printf("%d이면 %s입니다.", menu, Area);
		} while (menu != 0);
		System.out.println("나가!!");
	}

}
