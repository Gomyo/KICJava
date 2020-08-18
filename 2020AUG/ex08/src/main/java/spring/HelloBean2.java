package spring;

public class HelloBean2 implements Hello {
	public HelloBean2() {
		System.out.println("");
	}
	
	public void sayHello(String name) {
		System.out.println(name + "님 ㅎㅇ");
	}
}
