package pack2;

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
		BufferedReader br = null;
		try {
			System.out.println("Connecting...");
			// 옆자리 사람과 연결하려면 localhost를 ip로
			s = new Socket("localhost",7777);
			System.out.println("Done! Connected!");

			// 접속되면 데이터를 읽어서 찍어준다
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
			System.out.println("메세지 : "+br.readLine());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
			if (s != null) try {s.close();} catch (IOException e) {}
		}
	}

}
