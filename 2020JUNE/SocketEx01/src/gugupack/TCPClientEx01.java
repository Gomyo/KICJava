package gugupack;

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
			s = new Socket("localhost",7777);
			System.out.println("서버 4와 연결됨");

			System.out.println("전송을 원하는 메시지를 입력하세요.");
			// System.in
			// 보낼 내용 > 문자열으로 넣기
			br = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
			System.out.println("보낼 내용 > ");
			
			String sendMsg = br.readLine();
			
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			
			bw.write(sendMsg + System.lineSeparator());
			bw.flush();
			System.out.println("전송 완료");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
			String msg = br.readLine();
//			System.out.println(msg);
			String[] arrMsg = msg.split(",");
			for (String st : arrMsg) {
				System.out.println(st);
			}
			System.out.println("수신 완료");
			
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
