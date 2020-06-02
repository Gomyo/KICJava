
public class DefaultMethodTest implements DefaultMethodInterface {

	@Override
	public void abstractionMethod() {
		// TODO Auto-generated method stub
		System.out.println("You must redefine on child");
	}
	public static void main(String[] args) {
		DefaultMethodTest dmt = new DefaultMethodTest();
		dmt.abstractionMethod();
		dmt.defaultMethod();
	}

}
