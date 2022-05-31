package com.yedam.example2;

public class Card {
    //필드
	private static int Cardnum = 1100;
	
	private int CardId;
	

   //	생성자
	public Card() {
		Cardnum++;
		this.CardId = Cardnum;

	}

	// 메소드
	public static int getSerialNum() {
		return Cardnum;
	}
}
