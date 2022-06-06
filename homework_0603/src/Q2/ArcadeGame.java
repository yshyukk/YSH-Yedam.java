package Q2;

import java.util.Scanner;

public class ArcadeGame implements KeyPad {
	public Scanner sc = new Scanner(System.in);
	// 필드
	int mode;

	// 생성자
	public ArcadeGame() {
		this.mode = this.NORMAL_MODE;
		System.out.println("ArcadeGame 실행");
	}

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다.");

	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다.");

	}

	@Override
	public void rightUpButton() {
		if (this.mode == this.NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격");
		} else if (this.mode == this.HARD_MODE) {
			System.out.println("캐릭터가 연속 공격");
		}

	}

	@Override
	public void rightDownButton() {
		if (this.mode == this.NORMAL_MODE) {
			System.out.println("캐릭터가  HIT 공격");
		} else if (this.mode == this.HARD_MODE) {
			System.out.println("캐릭터가 Double HIT 공격");
		}
	}

	@Override
	public void changeMode() {

		if (this.mode == this.NORMAL_MODE) {
			this.mode = this.HARD_MODE;
			System.out.println("현재 모드는 HARD_MODE");
		} else if (this.mode == this.HARD_MODE) {
			this.mode = this.NORMAL_MODE;
			System.out.println("현재 모드는 NORMAL_MODE");
		}

	}

}
