package io01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioMain02 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			// 파일없으면 강제 생성 , 있으면 사용
			fos = new FileOutputStream("c:/java/test2.txt");
			
			fos.write('a');
			fos.write('b');
			fos.write('\r');
//			fos.write('\n');			
			fos.write('a');
			fos.write('b');
			
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) try {fos.close();} catch(IOException e) {} // 필수
		}
	}

}
