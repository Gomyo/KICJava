package Teachers;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class AddressListModel extends AbstractListModel<String> {

	private ArrayList<String> datas = new ArrayList<String>();
	
	public AddressListModel(String strDong) {
		TeacherZipcodeDAO2 dao = new TeacherZipcodeDAO2();
		datas = dao.allAddress(strDong);
	}
	
	@Override
	public String getElementAt(int index) {
		return datas.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}
}
