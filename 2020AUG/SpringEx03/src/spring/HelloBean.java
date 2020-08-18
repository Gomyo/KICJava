package spring;

public class HelloBean {
	// 객체
	// 2. 이 객체에 홍길동을 넣는다.
	private String name;
	private String firstName;
	private String lastName;
	
	public HelloBean() {
		System.out.println("HelloBean()");
	}
	
	public HelloBean(String name) {
		System.out.println("HelloBean(String name)");
		// 생성자를 통한 주입
		// 1. context에서 홍길동을 불러와서
		this.name = name;
	}
	public HelloBean(String firstName, String lastName) {
		System.out.println("HelloBean(first last Name)");
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void sayHello() {
		System.out.println(this.lastName + this.firstName + "님 안녕하세요.");
	}
	
}
