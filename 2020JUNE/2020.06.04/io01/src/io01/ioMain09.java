package io01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ioMain09 {
	public static void main(String[] args) {
		BufferedReader br = null;
//		BufferedReader br = new BufferedReader(new FileReader("c:/java/newtest.txt"));
		
		try {
			br = new BufferedReader(new FileReader("./newtext.txt"));
			
//			int data = 0;
//			while ((data= br.read()) != -1) {
//				System.out.print((char)data);
//			}
			
			String msg = null;
			while((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
			
		} catch (FileNotFoundException e) {
			// 
			System.out.println("[Error]" + e.getMessage());
		} catch (IOException e) {
			// 
			System.out.println("[Error]" + e.getMessage());
		} finally {
			if (br != null) try {br.close();} catch(IOException e) {}
		}
	}
}