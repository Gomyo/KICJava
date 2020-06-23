package PostFinal;

import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class PostFinalModel extends AbstractTableModel {

	private ArrayList<ToFinal> datas = new ArrayList<ToFinal>();

	public PostFinalModel(String strDong) {
		PostFinalDAO dao = new PostFinalDAO();
		datas = dao.allEmp(strDong);
	}

	private String[] columnNames = { "zipcode", "sido", "gugun", "dong", "ri", "bunji" };

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
		ToFinal to = datas.get(rowIndex);
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
