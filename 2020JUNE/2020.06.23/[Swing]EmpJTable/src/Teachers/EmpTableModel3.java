import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EmpTableModel3 extends AbstractTableModel {
	private ArrayList<EmpTO> values;
	
	public EmpTableModel3() {
		// TODO Auto-generated constructor stub
		EmpDAO dao = new EmpDAO();
		values = dao.allEmpTO();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		EmpTO to = values.get(rowIndex);
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








