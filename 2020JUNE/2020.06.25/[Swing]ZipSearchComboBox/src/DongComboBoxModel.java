import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class DongComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas = new ArrayList<String>();
	
	public DongComboBoxModel(String gugun) {
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.allDong(gugun);
	}
	@Override
	public int getSize() {
		return datas.size();
	}
		
	@Override
	public String getElementAt(int index) {
		return datas.get(index);
	}
	
}
