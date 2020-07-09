package pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// IP, POrt
		Socket s = null;
		try {
			System.out.println("Connecting...");
			s = new Socket("localhost",7777);
			System.out.println("Done! Connected!");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null) try {s.close();} catch (IOException e) {}
		}
	}

}
