import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JLabel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabel frame = new JLabel();
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
	public JLabel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 간격을 띄우기 위해 html 태그 사용
		javax.swing.JLabel lb1 = new javax.swing.JLabel("<html><body>라벨<br>라벨</body></html>");
		lb1.setBackground(Color.WHITE);
		lb1.setForeground(Color.RED);
		lb1.setBounds(12, 10, 85, 44);
		contentPane.add(lb1);
		
		javax.swing.JLabel lblNewLabel = new javax.swing.JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\git.png"));
		lblNewLabel.setBounds(100, 10, 211, 212);
		contentPane.add(lblNewLabel);
	}
}
