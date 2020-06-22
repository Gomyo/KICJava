package Quiz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ZipSearchQuiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchQuiz frame = new ZipSearchQuiz();
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
	public ZipSearchQuiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox SidoCB = new JComboBox();
		SidoCB.setModel(new SidoComboBoxModel());
		SidoCB.setBounds(12, 10, 129, 39);
		contentPane.add(SidoCB);

		JComboBox GugunCB = new JComboBox();
		GugunCB.setBounds(155, 10, 129, 39);
		contentPane.add(GugunCB);
		
		JComboBox DongCB = new JComboBox();
		DongCB.setBounds(296, 10, 129, 39);
		contentPane.add(DongCB);
		
		// 시도의 변화에 맞추어 구군을 업데이트. 동은 null값을 주어 빈 칸으로 바꾼다.
		SidoCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String sido = (String)SidoCB.getSelectedItem();
					GugunCB.setModel(new GugunComboBoxModel(sido));
					DongCB.setModel(new DongComboBoxModel(null));
				}
			}
		});
		
		// 구군의 변화에 맞추어 동 리스트를 새로 가져옴
		GugunCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String gugun = (String)GugunCB.getSelectedItem();
					DongCB.setModel(new DongComboBoxModel(gugun));
				}
			}
		});
	}

}
