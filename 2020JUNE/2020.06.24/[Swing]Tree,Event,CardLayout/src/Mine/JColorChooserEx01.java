package Mine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JColorChooserEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JColorChooserEx01 frame = new JColorChooserEx01();
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
	public JColorChooserEx01() {
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
				 Color color = JColorChooser.showDialog(JColorChooserEx01.this, "팔레트", Color.GREEN);
				 if (color != null) {
					 System.out.println(color.toString());
					 System.out.println("Red : "+color.getRed());
					 System.out.println("Red : "+color.getGreen());
					 System.out.println("Red : "+color.getBlue());
					 
					 
					 System.out.printf("Red : %x%n",color.getRed());
					 System.out.printf("Red : %x%n",color.getGreen());
					 System.out.printf("Red : %x%n",color.getBlue());
					 
				 }
			}
		});
		btnNewButton.setBounds(12, 21, 105, 51);
		contentPane.add(btnNewButton);
	}

}
