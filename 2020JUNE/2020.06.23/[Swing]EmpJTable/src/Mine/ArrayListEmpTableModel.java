package Mine;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArrayListEmpTableModel extends AbstractTableModel {
	private ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
	public ArrayListEmpTableModel() {
		ArrayListEmpDAO dao = new ArrayListEmpDAO();
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
		return datas.get(0).size();
	}
	// 행의 수
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}
	// 데이터 접근 방법
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datas.get(rowIndex).get(columnIndex);
	}

}
