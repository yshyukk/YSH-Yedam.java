package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamExample {

	public static void main(String[] args) throws Exception {
		//bufferStream이 없는 경우
		//getResource = 내가 찾고자 하는 파일.
		//getPath()= 내가 찾고자 하는 파일의 실제 위치.
		//내가 사용하는 위치와 실제로 사용하는 위치가 달라도 위치를 찾아가기때문에
		
		String originalFilePath1 = BufferStreamExample.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "C:/Users/admin/git/this.repository2/chap14/src/com/yedam/java/ch03/originalFile1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을 때 : " + nonBufferTime + "ns");
				
		fis1.close();
		fos1.close();
		//bufferStream이 있는 경우
		String originalFilePath2 = BufferStreamExample.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "D:/dv/temp/targetFile2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(originalFilePath2);
		
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long BufferTime = copy(bis, bos);
		System.out.println("버퍼를 사용했 때 : " + BufferTime + "ns");
				
		fis2.close();
		fos2.close();

	}
	static int data = -1;
	//읽어들여서 바로 복사
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		while(true) {
			data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		long end = System.nanoTime();
		return (end-start);
	}

}
