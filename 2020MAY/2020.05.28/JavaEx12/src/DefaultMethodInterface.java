
interface DefaultMethodInterface {
	void abstractionMethod(); // 반드시 구현 클래스에서 재정의해야 한다.
	
	default void defaultMethod() {
		System.out.println("This is default method.");
	}
}
