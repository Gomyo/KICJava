import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class ZipcodeListModel extends AbstractListModel<String> {
	private ArrayList<String> datas = new ArrayList<String>();
	
	public ZipcodeListModel(String zipcode) {
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.byZipcode(zipcode);
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return datas.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}
}
