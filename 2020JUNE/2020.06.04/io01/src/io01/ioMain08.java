package io01;

import java.io.FileWriter;
import java.io.IOException;

public class ioMain08 {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			// Overwriting 방식
//			fw = new FileWriter("c:/java/newtext.txt");
			
			// Appending 방식으로 쓰고 싶으면 옵션을 넣는다:
			fw = new FileWriter("c:/java/newtext.txt", true);
			
			fw.write("ㅇㄹㅇㄹ\r");
			fw.write("ㅇㄻㄴㅇㄹ\r");
			
			System.out.println("출력 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) try {fw.close();} catch(IOException e) {}
		}
	}

}
