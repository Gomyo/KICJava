package spring;

public class HelloBean1 implements Hello {
	private String name;
	
	public HelloBean1() {
		System.out.println("");
	}
	
	public HelloBean1(String name) {
		System.out.println("HelloBean1 호출");
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(name + "님 안녕하세요");
	}
	
	public void sayHello(String name) {
		System.out.println(name + "님 안녕하세요");
	}
}
