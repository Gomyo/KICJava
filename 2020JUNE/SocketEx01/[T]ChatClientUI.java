package chatting;

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
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.border.TitledBorder;

import chatting.ChatClient.ClientReceiver;
import chatting.ChatClient.ClientSender;

import javax.swing.UIManager;
import java.awt.Color;

public class ChatClientUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextArea textArea;
	
	private DataOutputStream dos = null;
	private Socket socket;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientUI frame = new ChatClientUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClientUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uCC44\uD305\uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 21, 456, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(12, 23, 324, 21);
		panel.add(textField1);
		textField1.setText("아이디 입력");
		textField1.setColumns(10);
		
		JButton btn1 = new JButton("연결");
		btn1.setBounds(348, 22, 97, 23);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				try {
					socket = new Socket("localhost", 7777);
					dos = new DataOutputStream( socket.getOutputStream() );
					
					Thread receiver = new Thread( new ClientReceiver( socket ) );
					receiver.start();
					
					dos.writeUTF( textField1.getText());
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		panel.add(btn1);
		
		textField2 = new JTextField();
		textField2.setBounds(12, 54, 324, 21);
		panel.add(textField2);
		textField2.setText("내용 입력");
		textField2.setColumns(10);
		
		JButton btn2 = new JButton("입력");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				try {
					dos.writeUTF( "[" + textField1.getText() + "]" + textField2.getText() );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn2.setBounds(348, 55, 97, 23);
		panel.add(btn2);
		
		JButton btn3 = new JButton("종료");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn3.setBounds(367, 506, 97, 23);
		contentPane.add(btn3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 454, 379);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText("내용 출력");
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
	
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream dos;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket ;
			try {
				dos = new DataInputStream( socket.getInputStream() );
			} catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			while(dos != null) {
				try {
					ChatClientUI.this.textArea.append( dos.readUTF() + "\n");
				} catch(IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
