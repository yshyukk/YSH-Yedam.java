package com.yedam.java.ch0702;

public class ChildTest {

	public static void main(String[] args) {
		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();
		
		GranFa fa = father;
		fa.method();
		fa = uncle;
		fa.method();
		fa = child;
		fa.method();
		fa = cousin;
		fa.method();
		
		Father pa = child;
		//pa = child;
		//pa = cousin;
		pa.method();
		
		System.out.println();
		Uncle un = cousin;
		//un = child;
		//un = father;
		un.method();
	}

}
