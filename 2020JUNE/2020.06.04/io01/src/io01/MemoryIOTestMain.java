package io01;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Arrays;

public class MemoryIOTestMain {

	public static void main(String[] args) {
		char[] memory ="안녕 Java World".toCharArray();
		char[] buffer = new char[5];
		
		int read = 0;
		
		try (CharArrayReader cr = new CharArrayReader(memory);
		CharArrayWriter cw = new CharArrayWriter();) 
		{
			while ((read = cr.read(buffer))>0) {
				cw.write(buffer,0,read);
			}
			System.out.println(Arrays.toString(cw.toCharArray()));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
