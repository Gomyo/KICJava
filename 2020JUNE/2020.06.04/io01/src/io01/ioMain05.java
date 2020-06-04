package io01;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioMain05 {

	public static void main(String[] args) {
//		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// 파일없으면 강제 생성 , 있으면 사용
//			fos = new FileOutputStream("c:/java/test2.txt");
			bos = new BufferedOutputStream(new FileOutputStream("c:/java/test2.txt"));
			
			bos.write('a');
			bos.write('b');
			bos.write('\r');
//			bos.write('\n');			
			bos.write('a');
			bos.write('b');
			
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) try {bos.close();} catch(IOException e) {} // 필수
		}
	}
	
}
