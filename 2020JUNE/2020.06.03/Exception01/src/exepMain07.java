
public class exepMain07 {
	void method (int num) {
		System.out.println("Start Method");
		if (num>=100) {
			System.out.println("num is bigger than 100");
		} else {
			System.out.println("GOGOGO");
		}
		System.out.println("End Method");
	}
	
	 
	void method1 (int num) {
		try {
			if (num >=100) {
				throw new MyException("num keo");
			}
		} 
		catch (Exception e) {
			System.out.println("Exception");
		}
	}
	// throws 키워드를 통한 처리 위임 : method 내에서 처리해야 할 하나 이상의 예외를 호출한 곳으로 던져버린다. 
	void method2 (int num) throws Exception {
		System.out.println("Start Method");
		if (num>=100) {
//			System.out.println("num is bigger than 100");
			throw new MyException("num 100>>");
		} else {
			System.out.println("GOGOGO");
		}
		System.out.println("End Method");
	}
	
	// 메인에서 throws Exception 통해 위임을 위임해 버리기도 가능함.
	public static void main(String[] args) {
		exepMain07 ex7 = new exepMain07();
		ex7.method(30);
		System.out.println("------------------------------------------------------------------------------");
		ex7.method(230);
		
		System.out.println("------------------------------------------------------------------------------");
		ex7.method1(20);
		
		System.out.println("------------------------------------------------------------------------------");
		ex7.method1(230);
		
		System.out.println("------------------------------------------------------------------------------");
//		ex7.method2(130); // 던진걸 처리 안했기 때문에 에러 발생
		// main에서 try-catch 처리
		try {
			ex7.method2(130);
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
