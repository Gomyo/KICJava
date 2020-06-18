import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class JButton1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JButton1 frame = new JButton1();
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
	public JButton1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("btn1");
		btn1.setBounds(12, 10, 96, 40);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("<html><body>버튼2<br>버튼2</body></html>");
		btn2.setBounds(11, 60, 97, 59);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setEnabled(true);
		btn3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\git.png"));
		btn3.setBounds(120, 10, 138, 153);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("btn4");
		btn4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseReleased");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mousePressed");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseExited");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseEntered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btn4.setBounds(12, 185, 97, 23);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("btn5");
		btn5.setBounds(129, 185, 97, 23);
		// 버튼4의 마우스리스너는 모든 경우를 처리해줘야 함. 그게 귀찮아서 mouseAdapter 클래스가 있다.
		btn5.addMouseListener(new MouseAdapter() {
			// 원하는 기능만 기술
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}
		});
		contentPane.add(btn5);
		// 마우스 우클릭 - 핸들러 설정으로도 가능
		JButton btn6 = new JButton("btn6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn6.setBounds(257, 185, 97, 23);
		contentPane.add(btn6);
	}
}
