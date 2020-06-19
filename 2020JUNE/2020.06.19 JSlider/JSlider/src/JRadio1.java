import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class JRadio1 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadio1 frame = new JRadio1();
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
	public JRadio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton btn1 = new JRadioButton("\uC288\uBC15");
		buttonGroup.add(btn1);
		btn1.setBounds(8, 48, 121, 23);
		contentPane.add(btn1);
		
		JRadioButton btn2 = new JRadioButton("\uB570\uAE30");
		buttonGroup.add(btn2);
		btn2.setBounds(8, 119, 121, 23);
		contentPane.add(btn2);
		
		JRadioButton btn3 = new JRadioButton("\uCC70\uC678");
		buttonGroup.add(btn3);
		btn3.setBounds(8, 190, 121, 23);
		contentPane.add(btn3);
	}
}
