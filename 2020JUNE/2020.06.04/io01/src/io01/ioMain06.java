package io01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioMain06 {

	public static void main(String[] args) {
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// 복사 - 바이너리 파일
//			fis = new FileInputStream("c:/java/Lighthouse.jpg");
			bis = new BufferedInputStream(new FileInputStream("c:/java/Lighthouse.jpg"));
			// image jpg -> png도 가능. 10가능~
//			fos = new FileOutputStream("c:/java/copied_Lighthouse.png");
			bos = new BufferedOutputStream(new FileOutputStream("c:/java/copied_Lighthouse.png"));
			int data =0;
			
			while ((data=bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("복사가 완료되었수~");
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) try {bos.close();} catch(IOException e) {}
		}
	}
}
