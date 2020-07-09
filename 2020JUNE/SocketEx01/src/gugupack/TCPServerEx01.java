package gugupack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.ObjectInputStream.GetField;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
					System.out.println("구구단 서버 준비");
					s = ss.accept();
					System.out.println("구구단 클라이언트 수신");
					
					// 에코 만들기
					br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
					bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
					
					String msg = br.readLine();
					int num = Integer.parseInt(msg);
					
					String result= "";
					for (int i=1; i<10; i++) {
						System.out.printf("%d X %d = %d\n",num,i,num*i);
						// concat은 안됨
//						result.concat(String.format("%d X %d = %d ,",num,i,num*i));
						result += String.format("%d X %d = %d ,",num,i,num*i);
//						System.out.println(result.getClass().getName());
//						System.out.println(result);
					}
					bw.write(result);
					bw.flush(); // 마지막에 쭉 짜줘서 끝내벌야 함
					System.out.println("계산한 구구단 전송 완료");
					
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
