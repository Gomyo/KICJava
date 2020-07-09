package pack2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket s = null;
		
		BufferedWriter bw = null;
		try {
			ss = new ServerSocket(7777);
			System.out.println("Server2 is ready");
			s = ss.accept();
			System.out.println("Client is connected");
			
//			s.getInputStream();
//			s.getOutputStream();
			
			// bw 전송
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			bw.write("안녕 클라이언트" + "\n");
			System.out.println("전송이완료크흡되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// BufferedWriter를 먼저 닫아줘야 함
			if (bw != null) try {bw.close();} catch (IOException e) {}
			if (ss != null) try {ss.close();} catch (IOException e) {}
			if (s != null) try {s.close();} catch (IOException e) {}
		}
	}

}
