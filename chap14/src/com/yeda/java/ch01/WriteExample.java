package com.yeda.java.ch01;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("D:/dv/temp/test1.db");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);
		os.write(b);
		os.write(c);
		
		//출력을 닫아야 할때 남아있을지도 모르는 데이터를 한번 밀어주고 .flush() 닫아야함.
		os.flush();
		os.close();
		
		os = new FileOutputStream("D:/dv/temp/test2.db");
		
		byte[] array = { 10, 20, 30};
		
		os.write(array);
		
		os.flush();
		os.close();
		
os = new FileOutputStream("D:/dv/temp/test3.db");
		
		byte[] array2 = { 10, 20, 30, 40, 50};
		
		os.write(array2, 3, 2);
		
		os.flush();
		os.close();
		
	}

}
