package Mine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
// 이벤트도 클래스화된 인터페이스 상속으로 가능
public class MouseListenerEventEx03 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseListenerEventEx03 frame = new MouseListenerEventEx03();
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
	public MouseListenerEventEx03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("버튼 1");
		btn.setBounds(12, 10, 97, 23);
		btn.addMouseListener(new UserMouseEvent());
		contentPane.add(btn);
		
		JButton btn2 = new JButton("버튼 2");
		btn2.setBounds(12, 40, 97, 23);
		btn2.addMouseListener(new UserMouseEvent());
		contentPane.add(btn2);
	}
}
