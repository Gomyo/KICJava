package pack1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {

		// Port Number - 각 프로그램이 1개 이상의 포트와 연관됨. 한 개의 포트를 두 개의 프로그램이 점유하지 못함
		// Server Socket

		ServerSocket ss = null;
		Socket s = null;

		try {
			ss = new ServerSocket(7777);
			System.out.println("Server is ready");
			// 접속 대기
			// 접속한 이후 소켓 경로로 이동해서 실행
			// 1. cd C:\Java\Java-workspace\SocketEx01\bin
			// 2. java pack1.TCPServerEx01
			// 이미 프로그램이 실행되고 있어서 종료하고 싶다면 (JVM_Bind 에러)
			// 1. netstat -ano 후, 해당 프로토콜의 로컬 주소를 확인해서 PID를 찾은 뒤
			// 2. 작업 관리자에서 종료. 정상적인 경우는 finally 부분에서 다 닫힘
			s = ss.accept();
			System.out.println("Client is connected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ss != null) try {ss.close();} catch (IOException e) {}
			if (s != null) try {s.close();} catch (IOException e) {}
		}

	}

}
