import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GugudanQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField front;
	private JTextField back;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GugudanQuiz frame = new GugudanQuiz();
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
	public GugudanQuiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAD6C\uAD6C\uB2E8\uC744\uC678\uC790", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 21, 397, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		front = new JTextField();
		front.setBounds(6, 18, 116, 21);
		panel.add(front);
		front.setColumns(10);
		
		back = new JTextField();
		back.setBounds(145, 18, 116, 21);
		panel.add(back);
		back.setColumns(10);
		
		JButton doGugu = new JButton("doGugu");
		doGugu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = Integer.parseInt(front.getText()); i <= Integer.parseInt(back.getText()); i++) {
					for (int j=1; j<=9; j++) {
						System.out.printf("%d X %d = %d\n",i,j,i*j);
					}
					System.out.println("");
				}
			}
		});
		doGugu.setBounds(294, 17, 97, 23);
		panel.add(doGugu);
		
		textArea = new JTextArea();
		textArea.setBounds(16, 87, 406, 149);
		contentPane.add(textArea);
	}

}
