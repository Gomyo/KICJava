import javax.swing.AbstractListModel;

public class CustomListModel extends AbstractListModel<String> {
	String[] values = new String[] {"수박", "참외", "딸기", "사과", "수박", "참외", "딸기", "사과", "수박", "참외", "딸기", "사과", "수박", "참외", "딸기", "사과"};
	
	
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return values[index];
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return values.length;
	}
	
}
