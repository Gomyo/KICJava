import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame04 extends JFrame {

	private JPanel contentPane;
	private JButton btn1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame04 frame = new Frame04();
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
	public Frame04() {
		setResizable(false);
		setTitle("title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// null로 바뀜 => absoluteLayout으로 변경. 이제부터 좌표로 배치할 거임
		contentPane.setLayout(null);
		btn1 = new JButton("\uB124\uC774\uBC84\uC778\uD134\uD569\uACA9\u3160\u3160\u3160\u3160");
		btn1.setBounds(12, 10, 161, 156);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("\uD588\uC744\uAC83\uC778\uAC00..!");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(204, 54, 97, 23);
		contentPane.add(btn2);
	}
}
