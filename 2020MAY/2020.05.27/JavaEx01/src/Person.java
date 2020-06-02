
public class Person {
	private String hakbun;
	private String name;
	
	// Default Constructor
	public Person() {
		// TODO Auto-generated constructor stub
	}

	// 편하게 치려면 마우스 우클릭(또는 Alt+shift+s) -  generate Constructor using field
	public Person(String hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
	}
	// generate getter and setter easily
	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
