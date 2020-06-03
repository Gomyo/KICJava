
public class exepMain04 {

	public static void main(String[] args) {
		String name = null;
		int num1 = 1;
		int num2 = 10;
		// 여러개의 예외처리를 뭉쳐서 할 수 있다.
		try {
			System.out.println("String Len"+name.length());
			int result = num2 / num1;
			System.out.println("Result : " + result);	
			// 둘 다 처리되지는 않음. else if 구문이라고 생각
		} catch (NullPointerException e) {
			System.out.println("Null Exception");
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic");
		}
		catch (Exception e) {
			// 이 코드는 else라고 보면 된다. else if 위에 else를 먼저 쓰면 당연히 에러가 나겠지? ㅇㅋ?
		}
		finally {
			// 자원의 할당
			System.out.println("언제나 실행");
		}
		
	}
}
