package Q2;

import java.util.Scanner;

public class RpgGame implements KeyPad {
	public Scanner sc = new Scanner(System.in);
//필드
	int mode;

//생성자
	public RpgGame() {
		this.mode = 1;
		System.out.println("RPGgame 실행");

	}

	
	// 메서드
	

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다.");

	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다.");

	}

	@Override
	public void rightUpButton() {
		
		if(mode == 1) {
			System.out.println("캐릭터가 위쪽으로 이동한다");
		}else if (mode == 2) {
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}
		
	}

	@Override
	public void rightDownButton() {
		if(mode == 1) {
			System.out.println("캐릭터가 일반 공격");
		}else if(mode == 2) {
			System.out.println("캐릭터가  HIT 공격");
		}
	}

	@Override
	public void changeMode() {
		System.out.println("모드변경 : 원하는 모드의 번호를 입력해주세요.");
		System.out.println("1. NORMAR_MODE | 2. HARD_MODE");
		int chmode = sc.nextInt();
		if (chmode == 1) {
			mode = 1;
			System.out.println("현재 모드는 NORMAL_MODE");
		}else if (chmode == 2) {
			mode = 2;
			System.out.println("현재 모드는 HARDE_MODE");
		}

	}

}
