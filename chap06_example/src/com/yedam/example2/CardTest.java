package com.yedam.example2;

public class CardTest {

	public static void main(String[] args) {
		
		CardFactory myCard = CardFactory.getInstance();

		Card create = myCard.createCard();
		System.out.println(create.getName());
	}

}
