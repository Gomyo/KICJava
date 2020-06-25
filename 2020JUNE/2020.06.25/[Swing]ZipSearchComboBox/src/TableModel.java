import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private ArrayList<DTO> datas = new ArrayList<DTO>();

	public TableModel(String strDong) {
		DAO dao = new DAO();
		datas = dao.allZipcode(strDong);
	}

	private String[] columnNames = { "우편번호", "시도", "구군", "동", "리", "번지" };

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DTO to = datas.get(rowIndex);
		String result = "";
		
		switch (columnIndex) {
		case 0:
			result = to.getZipcode();
			break;
		case 1:
			result = to.getSido();
			break;
		case 2:
			result = to.getGugun();
			break;
		case 3:
			result = to.getDong();
			break;
		case 4:
			result = to.getRi();
			break;
		case 5:
			result = to.getBunji();
			break;
		}
		return result;
	}


}
