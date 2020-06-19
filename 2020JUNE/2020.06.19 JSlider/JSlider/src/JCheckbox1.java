import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JCheckbox1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckbox1 frame = new JCheckbox1();
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
	public JCheckbox1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox checkbox1 = new JCheckBox("µþ±â");
		checkbox1.setSelected(true);
		checkbox1.setBounds(8, 48, 115, 23);
		contentPane.add(checkbox1);
		
		JCheckBox checkbox2 = new JCheckBox("¼ö¹Ú");
		checkbox2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkbox2.isSelected()) {
					System.out.println("¼±ÅÃµÊ");
				} else {
					System.out.println("¼±ÅÃ¾ÈµÊ");
				}
			}
		});
		checkbox2.setBounds(8, 119, 115, 23);
		contentPane.add(checkbox2);
		
		JCheckBox checkbox3 = new JCheckBox("´ç±Ù");
		checkbox3.setBounds(8, 190, 115, 23);
		contentPane.add(checkbox3);
		
		JButton isCheckedbtn = new JButton("New button");
		isCheckedbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(checkbox1.isSelected());
				System.out.println(checkbox2.isSelected());
				System.out.println(checkbox3.isSelected());
				
				System.out.println(checkbox1.getText());
				System.out.println(checkbox2.getText());
				System.out.println(checkbox3.getText());
			}
		});
		isCheckedbtn.setBounds(325, 10, 97, 23);
		contentPane.add(isCheckedbtn);
	}
}
