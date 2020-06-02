
interface StaticMethodInterface {
	static void StaticMethod() {
		System.out.println("Static Method");
	}
	
	public class StaticMethodTest {
		public static void main(String[] args) {
			StaticMethodInterface.StaticMethod();
		}
	}
}
