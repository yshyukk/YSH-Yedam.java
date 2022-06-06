package Q2;

public class Q3 {

	public static void main(String[] args) {

		int rpgGame = 1;
		int arcadeGame = 2;
		int gameMode = -1;
		
		double randomValue = Math.random();
		int random = (int)(Math.round(randomValue) +1 );
		System.out.println(random);
		
		
		
		RpgGame rpg = new RpgGame();
		ArcadeGame arc = new ArcadeGame();

//		while (true) {
//
//			if (gameMode == rpgGame) {
//			}
//		}

	}

}
