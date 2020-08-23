package polyspring;

public class HelloBean1 implements Hello {
	public HelloBean1() {
		System.out.println("HelloBean1");
	}
	
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("하이요" + name);
	}
}
