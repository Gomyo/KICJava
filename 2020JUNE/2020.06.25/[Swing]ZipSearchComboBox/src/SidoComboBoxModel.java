import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class SidoComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas = new ArrayList<String>();
	public SidoComboBoxModel() {
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.allSido();
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
