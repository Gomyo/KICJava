import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Progressbar1 extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Progressbar1 frame = new Progressbar1();
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
	public Progressbar1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(200);
		progressBar.setValue(150);
		progressBar.setBounds(12, 23, 393, 23);
		contentPane.add(progressBar);
		
		JButton btn1 = new JButton("증가");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 10씩 감소
				progressBar.setValue(progressBar.getValue() - 10);
			}
		});
		btn1.setBounds(12, 56, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("감소");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 10씩 증가
				progressBar.setValue(progressBar.getValue() + 10);
			}
		});
		btn2.setBounds(121, 56, 97, 23);
		contentPane.add(btn2);
	}
}
