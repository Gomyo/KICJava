import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class JTextField2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextField2 frame = new JTextField2();
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
	public JTextField2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("초기값");
		textField.setBounds(12, 10, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		/*
		 * JTextarea 
		 * Editable(true) -다중줄 입력
		 * Editable(false) -다중줄 출력
		 * */
		JTextArea textArea = new JTextArea("text \n text \n");
		textArea.setEditable(false);
		textArea.setBounds(12, 41, 116, 127);
		contentPane.add(textArea);

		passwordField = new JPasswordField();
		passwordField.setBounds(12, 198, 116, 23);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(passwordField.getText());
			}
		});
		btnNewButton.setBounds(148, 197, 97, 23);
		contentPane.add(btnNewButton);
		
	}
}
