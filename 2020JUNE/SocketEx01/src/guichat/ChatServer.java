package guichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer {
	// 채팅 룸 Chatting Room
	// 아이디, 출력스트림이 들어감
	private HashMap<String, OutputStream> clients;
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		new ChatServer().start();
	}
	public ChatServer() {
		clients = new HashMap<String, OutputStream>();
		// Collections.synchronizedMap(clients)
	}
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			while(true) {
				// 접속자의 정보를 파악할 수 있음.
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속하였습니다.");
				// accept되면 그 상태를 가지고 thread를 생성
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 브로드캐스팅 
	public void sendToAll(String msg) {
		// Iterator : 컬렉션에 저장되어 있는 요소들을 읽어오는 방법
		// Interface이며, 주요 멤버로는
		/*
		 * boolean hasNext()
		 * next()
		 * remove() 가 있다.*/
		Iterator<String> it = clients.keySet().iterator();
		// KeySet 메소드를 이용해 Map 계열의 전체 Key set을 반환한다.
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			} catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void run() {
			String name = "";
			try {
				// 외부에서 이름을 받아옴
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다.");
				// 등록
				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
				// 채팅 부분
				// 계속 루프를 돌면서 대화를 전체에게 send
				while(in != null) {
					/* 이렇게 하면 안됨
					if (in.readUTF().equals("exit")) {
						break;
					} else {
						sendToAll(in.readUTF());	
					} 
					*/
					String msg = in.readUTF();
					// 닉네임을 포함한 텍스트가 나가기 때문에 endsWith를 사용해야 한다
//					if (msg.equals("exit")) {
					if (msg.endsWith("exit")) {
						break;
					} else {
						sendToAll(msg);
					}
					
				}
			} catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 에러가 나면 나가버리게 하고 초기화 작업 (remove)
				sendToAll( "#" + name + "님이 나가셨습니다.");
				clients.remove( name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + " 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다.");
			}
		}
	}
}