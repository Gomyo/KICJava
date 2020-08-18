package spring;

public class HelloBean {
	// 문자열 (Object..) - 클래스
	private String name;
	
	public HelloBean() {
		System.out.println("HelloBean() 호출");
		this.name = "이몽룡";
	}
	
	public HelloBean(String name) {
		System.out.println("HelloBean(String name) 호출");
		this.name =name;
	}
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(this.name + "님, 안녕하세요?");
	}
}
