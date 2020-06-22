import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSpinner1 extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSpinner1 frame = new JSpinner1();
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
	public JSpinner1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(spinner.getValue());
			}
		});
//		spinner.setModel(new SpinnerNumberModel(10, 0, 100, 1));
		
		// Custom Instance
//		SpinnerNumberModel numModel = new SpinnerNumberModel(1,1,6,2);
//		spinner.setModel(numModel);
		
		// Custom Class
		CustomSpinnerNumberModel cnumModel = new CustomSpinnerNumberModel(1, 1, 53, 2);
		spinner.setModel(cnumModel);
		
		spinner.setBounds(12, 10, 179, 34);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerListModel(new String[] {"\uC2A4\uD2B8\uB85C\uBCA0\uC73C\uB9AC", "\uBC84\uB0B4\uB108", "\uD0A4\uC704", "\uD30C\uC778\uC571\uBED8", "\uD2C8\uBA54\uC774\uB3C4"}));
		spinner_1.setBounds(12, 76, 179, 34);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1592751600000L), new Date(1592751600000L), new Date(1600959600000L), Calendar.DAY_OF_YEAR));
		spinner_2.setBounds(12, 138, 179, 34);
		contentPane.add(spinner_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(spinner.getValue());
			}
		});
		btnNewButton.setBounds(236, 56, 179, 94);
		contentPane.add(btnNewButton);
	}
}
