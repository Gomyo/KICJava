package io03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResourceMain {

	public static void main(String[] args) {
		// finally를 아예 지워버리기 씹가눙
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("입력 > ");
			String msg = br.readLine();
			System.out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
