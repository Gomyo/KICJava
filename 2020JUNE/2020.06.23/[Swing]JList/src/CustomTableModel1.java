import javax.swing.table.AbstractTableModel;

public class CustomTableModel1 extends AbstractTableModel {
	private String[][] values = new String[][] {
		{"d", "a", "dsafasds", "d"},
		{null, "sasdfasdf", "d", "f"},
		{null, null, "ddsafasd", "f"},
	};
	private String[] names = new String[] {
			"기","승","전","결"
	};
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return names[column];
	}
	
	// 열의 수
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values[0].length;
	}
	// 행의 수
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.length;
	}
	// 데이터 접근 방법
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return values[rowIndex][columnIndex];
	}

}
