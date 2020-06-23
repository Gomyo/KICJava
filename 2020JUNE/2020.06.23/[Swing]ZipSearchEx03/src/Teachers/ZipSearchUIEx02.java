package Teachers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZipSearchUIEx02 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchUIEx02 frame = new ZipSearchUIEx02();
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
	public ZipSearchUIEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "우편번호 검색기", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 35, 675, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 18, 471, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println((String)list.getSelectedValue());
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 136, 652, 317);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(list);
		
		JButton btn = new JButton("검색");
		btn.setBounds(507, 17, 156, 23);
		panel.add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strDong = textField.getText();
				if (!strDong.equals("")) {
					list.setModel(new AddressListModel(strDong));
				} else {
					JOptionPane.showMessageDialog(
							ZipSearchUIEx02.this, 
							"동 이름을 입력해 주세요", 
							"에러메시지",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

		
	}
}
