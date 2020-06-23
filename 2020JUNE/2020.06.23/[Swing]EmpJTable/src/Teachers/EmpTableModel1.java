import javax.swing.table.AbstractTableModel;

public class EmpTableModel1 extends AbstractTableModel {
	private String[][] values;
	
	public EmpTableModel1() {
		// TODO Auto-generated constructor stub
		EmpDAO dao = new EmpDAO();
		values = dao.allEmp();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values[0].length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return values[rowIndex] [columnIndex];
	}

}
