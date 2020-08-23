package polyspring;

public class HelloBean2 implements Hello{
	public HelloBean2() {
		System.out.println("HelloBean2");
	}
	
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("하이요 헬로빈2임" + name);
	}
}
