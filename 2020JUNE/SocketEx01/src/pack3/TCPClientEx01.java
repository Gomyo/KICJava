package pack3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// 옆자리 사람이랑 통신하기
		Socket s = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			System.out.println("Connecting...");
			s = new Socket("192.168.0.42",7777);
			System.out.println("서버 3와 연결됨");

			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			
			bw.write("나는 클라이언트 3. 안녕 서버!" + System.lineSeparator());
			bw.flush();
			System.out.println("수신 완료");
			
			String msg = br.readLine();
			System.out.println("클라이언트 메시지 : "+msg);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
			if (bw != null) try {bw.close();} catch (IOException e) {}
			if (s != null) try {s.close();} catch (IOException e) {}
		}
	}

}
