package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ZipSearchMainUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchMainUI frame = new ZipSearchMainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ZipSearchMainUI() {
		setTitle("우편번호 검색기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "우편번호 검색", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 21, 762, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setBounds(6, 18, 230, 21);
		panel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setBounds(6, 49, 750, 21);
		panel.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setEditable(false);
		textField3.setBounds(6, 80, 750, 21);
		panel.add(textField3);
		textField3.setColumns(10);
		
		JButton btnOpenSearchDialog = new JButton("검색");
		btnOpenSearchDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ZipSearchDialogUI dialog = new ZipSearchDialogUI();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				if (dialog.getZipcode() != null) {
					textField1.setText(dialog.getZipcode());
					textField2.setText(dialog.getAddress());
				}
				if (!textField2.getText().isEmpty()) {
					textField3.setEditable(true);
				} 
			}
		});
		btnOpenSearchDialog.setBounds(248, 17, 97, 23);
		panel.add(btnOpenSearchDialog);
		
	}
}
