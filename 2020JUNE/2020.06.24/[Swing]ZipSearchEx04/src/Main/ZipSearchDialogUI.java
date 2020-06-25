package Main;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ZipSearchDialogUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dongTF;
	public JTable table;
	public ArrayList<String> result;
	private JButton btnSearchDialog;
	private String zipcode;
	private String address;
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public ZipSearchDialogUI() {

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setTitle("상세주소 검색");
		setBounds(100, 100, 813, 637);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			dongTF = new JTextField();
			dongTF.setBounds(127, 21, 326, 21);
			contentPanel.add(dongTF);
			dongTF.setColumns(10);
		}
		{
			btnSearchDialog = new JButton("검색");
			btnSearchDialog.setBounds(588, 20, 97, 23);
			contentPanel.add(btnSearchDialog);
			
			btnSearchDialog.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String strDong = dongTF.getText();
					if (!strDong.equals("")) {

						table.setModel(new ZipSearchModel(strDong));
						
						// 테이블 셀 렌더러 생성(가운데 정렬을 위함)
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
								ZipSearchDialogUI.this, 
								"동 이름을 입력해 주세요", 
								"에러메시지",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			});
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 80, 773, 475);
		contentPanel.add(scrollPane);
		
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("입력");
				okButton.setActionCommand("입력");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						//내 코드
						/*
						// 매번 클릭할 때마다 ArrayList 초기화
						ArrayList<String> result = new ArrayList<String>();
						for (int i=0; i<6; i++) {
							result.add(table.getValueAt(table.getSelectedRow(),i).toString());
						}
						// setText를 위한 String 변수 생성
						toMain = "";
						for (String s : result) {
							toMain += s +"\t";
						}
						*/
						
						// 선생님 코드
						// table에서 선택된 데이터 가져오기
						if (table.getSelectedRow() != -1) {
//							System.out.println(table.getValueAt(table.getSelectedColumn(), table.getSelectedRow()));
							ZipSearchDialogUI.this.setZipcode((String)table.getValueAt(table.getSelectedRow(),0));
							String strAddress = String.format("%s %s %s %s %s", 
									(String)table.getValueAt(table.getSelectedRow(),1),
									(String)table.getValueAt(table.getSelectedRow(),2),
									(String)table.getValueAt(table.getSelectedRow(),3),
									(String)table.getValueAt(table.getSelectedRow(),4),
									(String)table.getValueAt(table.getSelectedRow(),5)
									);
							ZipSearchDialogUI.this.setAddress(strAddress);
						}
						
						// 여기서는 값을 저장만 하고 받는건 메인에서 하자
						// 메인 테이블의 textField에 setText
						// 왜 setText가 안되지?
						/*
						
						zu.textField2.setText(toMain);
						zu.getResult(toMain);
						
						JTextField setTextField = new JTextField();
						setTextField.setText(toMain);
						*/
						ZipSearchDialogUI.this.dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setActionCommand("취소");
				buttonPane.add(cancelButton);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ZipSearchDialogUI.this.dispose();
					}
				});
			}
		}
		
		
	}
}
