package chat2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	static class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream out;
		private String name;
		
		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				if (out != null) {
					out.writeUTF(name);
				}
				while (out != null) {
					out.writeUTF("["+ name + "]" + br.readLine());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (br != null) try {br.close();} catch(IOException e) {}
			}
		}
	}
	
	static class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			while (in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// 닉네임 입력시키는건 br을 여기다가
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("닉네임 입력 > ");
			String name = br.readLine();
			Socket socket = new Socket("localhost",7777);
			
			System.out.println("서버에 연결됨");
			// 보내는 스레드
			Thread sender = new Thread(new ClientSender(socket,name));
			// 받는 스레드
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start();
			receiver.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
