package io01;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOMain {

	public static void main(String[] args) {
		DataOutputStream dos = null;
		
		// 2차 스트림
		try {
			dos = new DataOutputStream(new FileOutputStream("./value.dat"));
			
			dos.writeInt(2020);
			dos.writeUTF("UTF-8 형식으로 저장");
			dos. writeFloat(1.8f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dos != null) try {dos.close();} catch (IOException e) {}
		}
		
		System.out.println("출력 완료");
	}

}
