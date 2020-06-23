package Mine;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ToEmpTableModel extends AbstractTableModel {
	private ArrayList<ToEmp> datas = new ArrayList<ToEmp>();
	private String[] columnNames = {"empno","ename","job","mgr","hiredate","sal","comm","deptno"};
	
	public ToEmpTableModel() {
		ToEmpDAO dao = new ToEmpDAO();
		datas = dao.allEmp();
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}
	// 행의 수
	@Override
	public int getRowCount() {
//		 TODO Auto-generated method stub
		return datas.size();
	}
	// 데이터 접근 방법
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ToEmp to = datas.get(rowIndex);
		String result = "";
		switch(columnIndex) {
		case 0:
			result = to.getEmpno();
			break;
		case 1:
			result = to.getEname();
			break;
		case 2:
			result = to.getJob();
			break;
		case 3:
			result = to.getMgr();
			break;
		case 4:
			result = to.getHiredate();
			break;
		case 5:
			result = to.getSal();
			break;
		case 6:
			result = to.getComm();
			break;
		case 7:
			result = to.getDeptno();
			break;
		}
		return result;
	}
}