package com.yedam.java.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharterConvertExample {
	// 100% 문자로 구성되어있다면 문자기반 stream
	// 일반적으로 byte기반의 stream으로 읽어들이고 보조스트림을 이용해 문자로 변환하는 형태를 많이 사용.
	
	public static void main(String[] args) throws Exception {
		System.out.println("입력 문장 >");
		
		String data = new Scanner(System.in).nextLine();
		write(data);
		read();
	}

	// byte type 출력시스템
	public static void write(String str) throws Exception {
		// 내가 사용하고자 하는 스트림을 생성
		OutputStream os = new FileOutputStream("D:/dv/temp/test1.txt");
		
		//os.write(str); -> 오류나는 이유 : OutputStream은 byte기반이므로 String 불가
		// 그래서
		//OutputStreamWriter(os); -> (문자기반)Writer를 OutputStream(byte)과 연결한다.
		//결국 byte타입의 OutputStream에 String 사용하기 위해서 사용함.
		Writer writer = new OutputStreamWriter(os);
		
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static void read() throws Exception {
		InputStream is = new FileInputStream("D:/dv/temp/test1.txt");
		
		//직접적으로 주고받을 수 없기때문에 InputStreamReader에 주소X
		Reader reader = new InputStreamReader(is);
		
		//Char로 한 번에 읽어들이는 방법, while문 쓰지않고 한번만 읽어들이는 방법
		char [] buffer = new char[100];
		int readCharNum = reader.read(buffer);
		reader.close();
		
		//Char배열에 있는 것을 문자열(String)로 바꾸는 방법
		String data = new String(buffer, 0, readCharNum);
		System.out.println(data);
		
	}
}
