package Mine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFileChooseEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooseEx01 frame = new JFileChooseEx01();
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
	public JFileChooseEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Default는 MyDocument => 특정 디렉토리를 디폴트로 하고 싶다면 내용을 변경
				JFileChooser jfc = new JFileChooser("C:/Java");
				// 파일의 위치만을 지정
				// 파일 열기는 파일 IO가 해준다
				int result = jfc.showOpenDialog(JFileChooseEx01.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					System.out.println("열기");
					System.out.println(jfc.getSelectedFile().getAbsolutePath()); // 경로를 가져옴으로, Stream을 사용해 파일 열기가 가능해짐
					System.out.println(jfc.getSelectedFile().getName());
				} else {
					System.out.println("기타");
				}
				
			}
		});
		btnNewButton.setBounds(32, 28, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser jfc = new JFileChooser("C:/Java");
				int result = jfc.showSaveDialog(JFileChooseEx01.this);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					System.out.println("저장");
					System.out.println(jfc.getSelectedFile().getAbsolutePath());
					System.out.println(jfc.getSelectedFile().getName());
				} else {
					System.out.println("기타");
				}
			}
		});
		btnNewButton_1.setBounds(32, 74, 97, 23);
		contentPane.add(btnNewButton_1);
	}

}
