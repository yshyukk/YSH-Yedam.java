package Q2;

import java.util.Scanner;

public class RpgGame implements KeyPad {
	public Scanner sc = new Scanner(System.in);
//필드
	int mode;

//생성자
	public RpgGame() {
		this.mode = this.NORMAL_MODE;
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

		if (mode == this.NORMAL_MODE) {
			System.out.println("캐릭터가 한칸 단위로 점프한다");
		} else if (mode == this.HARD_MODE) {
			System.out.println("캐릭터가 두칸 단위로 점프한다.");
		}

	}

	@Override
	public void rightDownButton() {
		if (mode == this.NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격");
		} else if (mode == this.HARD_MODE) {
			System.out.println("캐릭터가  HIT 공격");
		}
	}

	@Override
	public void changeMode() {

		if (this.mode == this.NORMAL_MODE) {
			this.mode = this.HARD_MODE;
			System.out.println("현재 모드는 HRAD_MODE");
		} else if (this.mode == this.HARD_MODE) {
			this.mode = this.NORMAL_MODE;
			System.out.println("현재 모드는 NORMAL_MODE");
		}

	}

}
