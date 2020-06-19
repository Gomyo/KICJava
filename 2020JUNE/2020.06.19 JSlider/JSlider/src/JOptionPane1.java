import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JOptionPane1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane1 frame = new JOptionPane1();
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
	public JOptionPane1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(JOptionPane1.this, "난 메세지");
				JOptionPane.showMessageDialog(JOptionPane1.this, "난 메세지", "난 타이틀", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(JOptionPane1.this, "난 메세지","난 타이틀", JOptionPane.OK_CANCEL_OPTION); // int 값을 리턴받을 수 있음
				System.out.println(result);
				// 옵션을 상수화 해 두었음
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("OK 클릭");
				}
			}
		});
		btnNewButton_1.setBounds(12, 49, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg = JOptionPane.showInputDialog(JOptionPane1.this,"난 메시지");
				System.out.println("내용 : " + msg);
			}
		});
		btnNewButton_2.setBounds(12, 94, 97, 23);
		contentPane.add(btnNewButton_2);
	}

}
