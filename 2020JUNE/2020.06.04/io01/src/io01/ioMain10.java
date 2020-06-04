package io01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ioMain10 {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("./ntext.txt"));
			
			bw.write("이............거어...ㄴ!! 꿈인걸..알지히만... 지금 이히 대해 로호 깨지 않고 서-어\r");
			bw.write("영원히 잠 들수있다면 꽈ㄱ 안아 주세요~");
			
			System.out.println("출력 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) try {bw.close();} catch (IOException e) {}
		}
	}

}
