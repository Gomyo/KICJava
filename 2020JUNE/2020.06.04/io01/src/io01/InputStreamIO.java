package io01;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;

import javax.sound.sampled.AudioFormat.Encoding;

public class InputStreamIO {

	public static void main(String[] args) {
		// 키보드로 입력
		InputStream is = null;
		
		// 표준입력장치(키보드)
		try {
			is = System.in;
			System.out.println("입력 > ");
			
			char c = (char)is.read();
			// 읽고 싶은 글자의 수만큼 입력
//			System.out.print("입력값 : "+ c );
			// 엔터키까지 인식하려면?
			
			int data = 0;
			StringBuffer sb = new StringBuffer();
			
			
			// is.read()로 하면 ASCII2 값 return. \n은 보통 13번
			while ((data = is.read()) != 13) {
//				System.out.print((char)data);
				sb.append((char)data);
			}
			String str = sb.toString();
			String[] list = str.split(" ");
			
			System.out.println(String.join(" ", list));
//			for (String i : list) {
//				i = i.substring(0,1).toUpperCase() + i.substring(1);
//				System.out.println(i);
//			}
			
//			System.out.println();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error : " + e.toString());
		} finally {
			if (is !=null) try {is.close();} catch (IOException e) {}
		}
	}

}
