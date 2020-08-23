package spring;

public class HelloBean1 {
	private String name;
	
	public HelloBean1() {
		System.out.println("HelloBean1()호출");
	}
	
	public HelloBean1(String name) {
		// TODO Auto-generated constructor stub
		System.out.println("HelloBean1(String)호출");
		this.name = name;
	}
	
	private void sayHello() {
		System.out.println(name + "님, 안녕하세요!");
	}
	
}
