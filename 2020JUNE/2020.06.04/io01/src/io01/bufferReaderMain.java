package io01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bufferReaderMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		// System in만 가지고는 한글 변경이 안돼서 변경시키는데 그것을 buffer로 가속화시킨 것
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("입력 > ");
//			int data = br.read();
//			System.out.println((char)data);
			// 지겨우니까 한번에 좀 받아버리자 ㅡㅡ
			String msg = br.readLine();
			System.out.println(msg);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
		}
	}

}
