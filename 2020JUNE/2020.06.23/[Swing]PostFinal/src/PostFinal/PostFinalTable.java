package PostFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PostFinalTable extends JFrame {

	private JPanel contentPane;
	private JTextField dongTF;
	private JTable table;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostFinalTable frame = new PostFinalTable();
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
	public PostFinalTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "우편번호 검색기_제출용.psd", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 10, 846, 626);
		contentPane.add(panel);
		panel.setLayout(null);
		
		dongTF = new JTextField();
		dongTF.setBounds(130, 18, 332, 34);
		panel.add(dongTF);
		dongTF.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(508, 17, 120, 34);
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 62, 828, 554);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// 검색 이벤트 리스너
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strDong = dongTF.getText();
				if (!strDong.equals("")) {

					table.setModel(new PostFinalModel(strDong));
					
					// 테이블 셀 렌더러 생성
					DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
					// 가운데 정렬로 지정
					dtcr.setHorizontalAlignment(SwingConstants.CENTER);
					// 정렬할 테이블의 ColumnModel을 가져온다
					TableColumnModel tcm = table.getColumnModel();
					// 반복문을 이용해서 테이블을 가운데 정렬
					for (int i =0; i<tcm.getColumnCount(); i++) {
						tcm.getColumn(i).setCellRenderer(dtcr);
					}
				} else {
					JOptionPane.showMessageDialog(
							PostFinalTable.this, 
							"동 이름을 입력해 주세요", 
							"에러메시지",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
