package com.yedam.java.ch0901;

public class Button {

	OnClickListener listner;
	
	void setOnclickListener(OnClickListener listener)
	{this.listner = listener;
		
	}
	void touch() {
		listner.onClick();
	}
	static interface OnClickListener{
		void onClick();
		
	}
}
