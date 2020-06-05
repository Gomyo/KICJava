import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
	private String name;
	private String phone;
	private int age;
	
	// setter를 대신하는 constructor
	public Person(String name, String phone, int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
	
	}
	
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}
	
}
