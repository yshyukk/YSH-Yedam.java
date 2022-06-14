package com.yeda.java.ch01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:/dv/temp/test1.db");
		while (true) {
			int data = is.read();
			if (data == -1)
				break;
			System.out.println(data);
		}
		is.close();

		System.out.println("=====================================");
		is = new FileInputStream("D:/dv/temp/test2.db");
		byte[] buffer = new byte[100];
		while (true) {
			int readByteNum = is.read(buffer);
			if (readByteNum == -1)
				break;
			for (int i=0; i<readByteNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		is.close();

		System.out.println("=====================================");
		is = new FileInputStream("D:/dv/temp/test3.db");

		// buffer의 3번째 index에서 2칸만큼 가져오겠다.
		int readByteNum = is.read(buffer, 3, 2);

		for (int i = 0; i < (3 + readByteNum); i++) {
			System.out.println(buffer[i]);
		}

		is.close();
	}
}
