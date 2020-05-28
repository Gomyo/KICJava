package juminCheck;

public class Util01 {
	private String name;
	private int juminnum;
	
	public Util01() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name != null) {
		this.name = name;
		}
		else {
			System.out.println("Access Denied");
		}
	}
	public int getJuminnum() {
		return juminnum;
	}
	public void setJuminnum(int juminnum) {
		if (juminnum == 951102) {
			this.juminnum = juminnum;
		}
		else {
			System.out.println("Access Denied");
		}
	}
	
}
