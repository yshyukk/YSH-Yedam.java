package Q2;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		RpgGame rpg = null;
		ArcadeGame arc = null;
		int rpgGame = 1;
		int arcadeGame = 2;
		int count = 0;

		double randomValue = Math.random();
		int random = (int) (Math.round(randomValue) + 1);
		System.out.println(random);

		printMenu();
		
		
		while (true) {
			// 먼저 RPG인지 ARCADE인지 게임종류
			
			if (random == 1) {
				if (count == 0) {
					rpg = new RpgGame();
					count++;
				}

				int selectMenu;
				selectMenu = sc.nextInt();
				System.out.println("Choice>> " + selectMenu);

				if (selectMenu == 1) {
					rpg.leftUpButton();
				} else if (selectMenu == 2) {
					rpg.leftDownButton();
				} else if (selectMenu == 3) {
					rpg.rightUpButton();
				} else if (selectMenu == 4) {
					rpg.rightDownButton();
				} else if (selectMenu == 5) {
					rpg.changeMode();
				} else if (selectMenu == 0) {
					random = 2;
					count = 0;
				} else if (selectMenu == 9) {
					System.exit(0);
					break;
				}

			} else if (random == 2) {
				if (count == 0) {
					count++;
					arc = new ArcadeGame();
				}
				int selectMenu;
				selectMenu = sc.nextInt();
				System.out.println("Choice>> " + selectMenu);

				if (selectMenu == 1) {
					arc.leftUpButton();
				} else if (selectMenu == 2) {
					arc.leftDownButton();
				} else if (selectMenu == 3) {
					arc.rightUpButton();
				} else if (selectMenu == 4) {
					arc.rightDownButton();
				} else if (selectMenu == 5) {
					arc.changeMode();
				} else if (selectMenu == 0) {
					random = 1;
					count = 0;
				} else if (selectMenu == 9) {
					System.exit(0);
					break;
				}

			}
		}

	}
	public static void printMenu() {
		System.out.println(
				"===========================================================================================");
		System.out.println(
				"<< 1. LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println(
				"===========================================================================================");
		
	}

}
