package pack4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		

		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			ss = new ServerSocket(7777);
			// 서버 계속 열어두기 (무한 루프)
			// 접속 - 준비 - 소켓 돌리기 무한 루프니까
			// 접속 부분을 while 루프로 걸어 줘야 계속 받겠지?
			while (true) {
				try {
					System.out.println("Server4 is ready");
					s = ss.accept();
					System.out.println("Client is connected");
					
					// 에코 만들기
					br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
					bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
					
					String msg = br.readLine();
					System.out.println("서버에 표시할 메시지 : " + msg);
					
					bw.write("메시지 1" + msg + System.lineSeparator());
					bw.flush(); // 마지막에 쭉 짜줘서 끝내벌야 함
					
					System.out.println("전송 완료");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 값을 다 받으면 다시 닫아준 뒤 열기
					if (br != null) try {br.close();} catch (IOException e) {}
					if (bw != null) try {bw.close();} catch (IOException e) {}
					if (s != null) try {s.close();} catch (IOException e) {}
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ss != null) try {ss.close();} catch (IOException e) {}
		}

	}

}
