package Mine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMenuEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuEx01 frame = new JMenuEx01();
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
	public JMenuEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mn1 = new JMenu("메뉴1");
		menuBar.add(mn1);
		
		JMenuItem mItem11 = new JMenuItem("아이템1");
		mItem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("메뉴아이템 1-1 클릭");
			}
		});
		mn1.add(mItem11);
		
		JMenuItem mItem12 = new JMenuItem("아이템2");
		mn1.add(mItem12);
		
		JMenuItem mItem13 = new JMenuItem("아이템3");
		mn1.add(mItem13);
		
		JMenu mn2 = new JMenu("메뉴2");
		menuBar.add(mn2);
		
		JMenuItem mItem21 = new JMenuItem("아이템2-1");
		mn2.add(mItem21);
		JMenuItem mItem22 = new JMenuItem("아이템2-2");
		mn2.add(mItem22);
		JMenuItem mItem23 = new JMenuItem("아이템2-3");
		mn2.add(mItem23);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
