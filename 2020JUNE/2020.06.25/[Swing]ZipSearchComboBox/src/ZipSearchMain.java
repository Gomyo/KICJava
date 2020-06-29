import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;

public class ZipSearchMain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchMain frame = new ZipSearchMain();
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
	public ZipSearchMain() {
		setTitle("우편번호콤보박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "우편번호 검색하기", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 34, 823, 70);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox SidoCB = new JComboBox();

		SidoCB.setBounds(6, 17, 197, 30);
		SidoCB.setModel(new SidoComboBoxModel());
		panel.add(SidoCB);

		JComboBox GugunCB = new JComboBox();
		GugunCB.setBounds(320, 17, 197, 30);
		panel.add(GugunCB);

		JComboBox DongCB = new JComboBox();
		
		DongCB.setBounds(620, 17, 197, 30);
		panel.add(DongCB);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 165, 811, 405);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// 시도의 변화에 맞추어 구군을 업데이트. 동은 null값을 주어 빈 칸으로 바꾼다.
		SidoCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String sido = (String) SidoCB.getSelectedItem();
					GugunCB.setModel(new GugunComboBoxModel(sido));
					DongCB.setModel(new DongComboBoxModel(null));
				}
			}
		});

		// 구군의 변화에 맞추어 동 리스트를 새로 가져옴
		GugunCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String gugun = (String) GugunCB.getSelectedItem();
					DongCB.setModel(new DongComboBoxModel(gugun));
				}
			}
		});
		// 마지막으로 동을 선택한다
		DongCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String strDong = (String) DongCB.getSelectedItem();
					if (!strDong.equals("")) {
						table.setModel(new TableModel(strDong));
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								ZipcodeDetailDialog dialog = new ZipcodeDetailDialog();
								if (table.getSelectedRow() != -1) {
									dialog.setZipcodeLabel("우편번호 : " + (String)table.getValueAt(table.getSelectedRow(), 0));
									dialog.setSidoLabel("시도 : " + (String)table.getValueAt(table.getSelectedRow(), 1));
									dialog.setGugunLabel("구군 : " + (String)table.getValueAt(table.getSelectedRow(), 2));
									dialog.setDongLabel("동 : " + (String)table.getValueAt(table.getSelectedRow(), 3));
									dialog.setLiLabel("리 : " + (String)table.getValueAt(table.getSelectedRow(), 4));
									dialog.setBunjiLabel("번지 : " + (String)table.getValueAt(table.getSelectedRow(), 5));
								}
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setModal(true);
								dialog.setVisible(true);
							};
						});
					} else {
						JOptionPane.showMessageDialog(
								ZipSearchMain.this, 
								"동 이름을 입력해 주세요", 
								"에러메시지",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		
		
	}
}
