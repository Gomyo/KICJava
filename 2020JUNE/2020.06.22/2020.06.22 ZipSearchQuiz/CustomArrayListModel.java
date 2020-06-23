import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class CustomArrayListModel extends AbstractListModel<String> {
	private ArrayList<String> values = new ArrayList<String>();
	
	public CustomArrayListModel() {
		values.add("수박");
		values.add("딸기");
		values.add("참외");
	}
	
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return values.get(index);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return values.size();
	}
	
}
