package pack3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		// 옆자리 사람이랑 통신하기
		ServerSocket ss = null;
		Socket s = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			ss = new ServerSocket(7777);
			System.out.println("Server3 is ready");
			s = ss.accept();
			System.out.println("Client3 is connected");
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			
			String msg = br.readLine();
			System.out.println("서버에 표시할 메시지 : " + msg);
			
			bw.write(msg + System.lineSeparator());
			bw.flush(); // 마지막에 쭉 짜줘서 끝내벌야 함
			
			System.out.println("전송 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
			if (bw != null) try {bw.close();} catch (IOException e) {}
			if (ss != null) try {ss.close();} catch (IOException e) {}
			if (s != null) try {s.close();} catch (IOException e) {}
		}

	}

}
