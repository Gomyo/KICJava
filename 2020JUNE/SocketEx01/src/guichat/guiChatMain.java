package guichat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;

public class guiChatMain extends JFrame {

	private JPanel contentPane;
	private JTextField loginTF;
	private JTextField chatTF;

	private Socket socket;
	private DataOutputStream dos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiChatMain frame = new guiChatMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public guiChatMain() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		loginTF = new JTextField();
		loginTF.setBounds(224, 10, 159, 23);
		contentPane.add(loginTF);
		loginTF.setColumns(10);

		JButton loginBtn = new JButton("로그인");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					socket = new Socket("localhost", 7777);
					dos = new DataOutputStream(socket.getOutputStream());
					
					Thread receiver = new Thread(new ClientReceiver(socket));
					receiver.start();
					
					dos.writeUTF(loginTF.getText());
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setBounds(408, 10, 97, 23);
		contentPane.add(loginBtn);

		JButton chatBtn = new JButton("채팅");
		chatBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		chatBtn.setBounds(408, 58, 97, 23);
		contentPane.add(chatBtn);

		JButton endBtn = new JButton("대화 종료");
		endBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		endBtn.setBounds(449, 461, 97, 23);
		contentPane.add(endBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 534, 351);
		contentPane.add(scrollPane);

		JTextArea chatLog = new JTextArea();
		scrollPane.setViewportView(chatLog);

		chatTF = new JTextField();
		chatTF.setBounds(12, 58, 371, 23);
		contentPane.add(chatTF);
		chatTF.setColumns(10);
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
					// 자동으로 개행이 되도록
					System.out.println(in.readUTF()+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
