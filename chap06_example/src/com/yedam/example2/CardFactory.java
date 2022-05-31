package com.yedam.example2;

public class CardFactory {
	//필드
	
	private static CardFactory instance = new CardFactory();	// 생성자 막아놨기때문에 여기서 생성 (new)
																// 내가 생성한 메서드로만 공유할꺼임 (static)
	//생성자
	private CardFactory() {}
	
	
	//메소드
	public static CardFactory getInstance() {
		return instance;
	}
	public Card createCard() {	// createCard의 기능은
		return new Card(); // 새로운카드를 생성
	}
	
	//
	
}
