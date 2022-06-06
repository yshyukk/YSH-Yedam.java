package Q2;

public class Play {

	public static void main(String[] args) {

		RpgGame rpg = new RpgGame(); // RpgGame의 인스턴스를 생성하고, 메서드를 불러온다.
		rpg.leftUpButton(); // RpgGame의 메서드를 불러온다.
		rpg.rightUpButton();
		rpg.changeMode();
		rpg.rightUpButton();
		rpg.rightDownButton();
		rpg.leftDownButton();
		rpg.changeMode();
		rpg.rightDownButton();

		System.out.println("====================================");

		ArcadeGame Arcade = new ArcadeGame();
		Arcade.leftUpButton();
		Arcade.rightUpButton();
		Arcade.leftDownButton();
		Arcade.changeMode();
		Arcade.rightUpButton();
		Arcade.leftUpButton();
		Arcade.rightDownButton();

	}

}
