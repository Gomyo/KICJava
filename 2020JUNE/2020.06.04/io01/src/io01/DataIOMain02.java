package io01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataIOMain02 {
	public static void main(String[] args) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("./value.dat"));
			
			int i = dis.readInt();
			String s = dis.readUTF();
			float f = dis.readFloat();
			
			System.out.println(i);
			System.out.println(s);
			System.out.println(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dis != null) try {dis.close();} catch (IOException e) {}
		}
	}
}
