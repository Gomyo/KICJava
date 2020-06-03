package io01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ioMain01 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:/java/test2.txt");
			int data =0;
			
			while ((data=fis.read()) != -1) {
//				System.out.println((char)data);
				// fis는 enter도 읽음
				// windows : \r\r
				// Linux : \n
				if (data == '\n') {
					System.out.println("엔터");
				}
				else {
					System.out.print((char)data);	
				}
			}
//			data = fis.read();
//			System.out.println(data); // ascii 값이 나오니 char로 변환하면 됨
//			System.out.println((char)data);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) try {fis.close();} catch(IOException e) {}
		}
	}

}
