import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class gugudanTeachers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gugudanTeachers frame = new gugudanTeachers();
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
	public gugudanTeachers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(16, 10, 404, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("보기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strStartDan = textField.getText();
				String strEndDan = textField_1.getText();
				
				if (strStartDan.equals("") || strEndDan.equals("")) {
					textArea.setText("입력값이 없습니다.");
				} else {
					try {
						
					int intStartDan = Integer.parseInt(strStartDan);
					int intEndDan = Integer.parseInt(strEndDan);
					// 구구단 표시는 이곳에
						for (int i = intStartDan; i <= intEndDan; i++) {
							for (int j=1; j<=9; j++) {
								textArea.setText(i+"X"+j+"="+i*j+"\t");
							}
							textArea.setText("");
						}
					} catch(NumberFormatException nfe) {
						textArea.setText("이건 숫자가 아니다!" + nfe.getMessage());
					}
					
				}
			}
		});
		btnNewButton.setBounds(301, 17, 97, 23);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(6, 18, 116, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 18, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 77, 408, 402);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
