package io01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioMain03 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 복사 - 바이너리 파일
			fis = new FileInputStream("c:/java/Lighthouse.jpg");
			// image jpg -> png도 가능. 10가능~
			fos = new FileOutputStream("c:/java/copied_Lighthouse.png");
			int data =0;
			
			while ((data=fis.read()) != -1) {
				fos.write(data);
			}
			System.out.println("복사가 완료되었수~");
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) try {fos.close();} catch(IOException e) {}
		}
	}
}
