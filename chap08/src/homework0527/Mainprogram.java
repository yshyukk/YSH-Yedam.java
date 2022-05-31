package homework0527;

import java.util.Scanner;

public class Mainprogram {
	
	/*private BookProgram program = new BookProgram();
	 * 
	 * 
	 * 
	 */
	
	private Scanner sc = new Scanner(System.in);
	private BookAccess sto = BookRepo.getInstance();
	private BookProgram pro = new BookSystem();

	public void MainProgram() {

		while (true) {
			// 메뉴 출력
			pro.menuPrint();
			// 메뉴 선택
			int menuNo = menuSelect();
			// 메뉴 실행
			while (true) {
				if (menuNo == 1) {
					pro.inputInfo(sto);
					break;
				} else if (menuNo == 2) {
					pro.printAllInfo(sto);
					break;
				} else if (menuNo == 3) {
					pro.printInfo(sto);
					break;
				} else if (menuNo == 4) {
					pro.printRepo(sto);
					break;
				} else if (menuNo == 5) {
					exit();
					break;
				}

			}

		}

	}

	private int menuSelect() {
		System.out.println("선택 > ");
		return sc.nextInt();
	}

	private void exit() {
		System.out.println("프로그램 종료합니다.");
	}
}
