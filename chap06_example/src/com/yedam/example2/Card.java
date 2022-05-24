package com.yedam.example2;

public class Card {
//
	private static int Cardnum = 1100;
	private int CardId;
	private String name;
	
	
//	
	public Card() {
		Cardnum++;
		this.CardId = Cardnum;	
			
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
