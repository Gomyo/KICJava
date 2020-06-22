import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomJComboBox1 extends DefaultComboBoxModel<String> {
//	private String [] datas = new String[] {"사과","배추","파","아귀"};
	
	private ArrayList<String> datas;
	
	public CustomJComboBox1() {
		datas = new ArrayList<String>();
		datas.add("사과");
		datas.add("과실");
		datas.add("딸기");
		datas.add("사과");
	}
	
	// 이렇게 가져올수도 있다
	public CustomJComboBox1(ArrayList<String> datas) {
		this.datas = datas;
	}
	
	// callback
	@Override
	public int getSize() {
//		System.out.println("getSize 호출");
//		return datas.length;
		return datas.size();
	}
	
	@Override
	public String getElementAt(int index) {
//		System.out.println("getElement 호출");
//		return datas[index];
		return datas.get(index);
	}
}
