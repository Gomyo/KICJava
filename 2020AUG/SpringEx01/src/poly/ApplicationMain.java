package poly;

public class ApplicationMain {
	public static void main(String[] args) {
		Hello hellobean = new HelloBean1();
		hellobean.sayHello("자바");
		
		hellobean = new HelloBean2();
		hellobean.sayHello("파이썬");
	}
}
