package io03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

// 한국어도 받아들일 수 있게
public class koreanioMain02 {

	public static void main(String[] args) {
		// 키보드로 입력
		InputStream is = null;
		Reader reader = null;
		
		// 표준입력장치(키보드)
		try {
			is = System.in;
			reader = new InputStreamReader(is);
			System.out.println("입력 > ");
			char c = (char)reader.read();
			
			System.out.print("입력값 : "+ c );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error : " + e.toString());
		} finally {
			if (reader !=null) try {reader.close();} catch (IOException e) {}
		}
	}

}
