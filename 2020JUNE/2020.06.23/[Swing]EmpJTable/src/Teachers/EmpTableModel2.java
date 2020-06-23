import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EmpTableModel2 extends AbstractTableModel {
	private ArrayList<ArrayList<String>> values;
	
	public EmpTableModel2() {
		// TODO Auto-generated constructor stub
		EmpDAO dao = new EmpDAO();
		values = dao.allArrayListEmp();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values.get(0).size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return values.get(rowIndex).get(columnIndex);
	}

}
