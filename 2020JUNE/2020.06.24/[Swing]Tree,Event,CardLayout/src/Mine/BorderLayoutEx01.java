package Mine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class BorderLayoutEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderLayoutEx01 frame = new BorderLayoutEx01();
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
	public BorderLayoutEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(20, 20));
		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("West");
		contentPane.add(btnNewButton_1, BorderLayout.WEST);
		
		JButton btnNewButton_3 = new JButton("East");
		contentPane.add(btnNewButton_3, BorderLayout.EAST);
		
		JButton btnNewButton_4 = new JButton("South");
		contentPane.add(btnNewButton_4, BorderLayout.SOUTH);
		
		Panel panel = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(40);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		Panel gridPanel = new Panel();
		contentPane.add(gridPanel, BorderLayout.CENTER);
		gridPanel.setLayout(new GridLayout(3, 3, 10, 10));
		
		JButton btnNewButton_10 = new JButton("New button");
		gridPanel.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("New button");
		gridPanel.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton("New button");
		gridPanel.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("New button");
		gridPanel.add(btnNewButton_13);
		
		JButton btnNewButton_2 = new JButton("New button");
		gridPanel.add(btnNewButton_2);
		
		JButton btnNewButton_14 = new JButton("New button");
		gridPanel.add(btnNewButton_14);
	}

}
