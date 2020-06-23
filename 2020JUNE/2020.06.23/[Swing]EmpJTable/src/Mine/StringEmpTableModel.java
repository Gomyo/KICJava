package Mine;

import javax.swing.table.AbstractTableModel;

public class StringEmpTableModel extends AbstractTableModel {
	private String[][] datas = new String[14][];
	public StringEmpTableModel() {
		StringEmpDAO dao = new StringEmpDAO();
		datas = dao.allEmp();
	}
	private String[] columnNames = {"empno","ename","job","mgr","hiredate","sal","comm","deptno"};
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return datas[0].length;
	}
	// 행의 수
	@Override
	public int getRowCount() {
//		 TODO Auto-generated method stub
		return datas.length;
	}
	// 데이터 접근 방법
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datas[rowIndex][columnIndex];
	}
}