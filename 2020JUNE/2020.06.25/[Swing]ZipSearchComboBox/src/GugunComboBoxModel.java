import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class GugunComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas = new ArrayList<String>();

	public GugunComboBoxModel(String sido) {
		DAO dao = new DAO();
		datas = dao.allGugun(sido);
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
