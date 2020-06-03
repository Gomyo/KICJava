
public class exepMain01 {

	public static void main(String[] args) {
		System.out.println("Start");
		
		int num1 = 0;
		int num2 = 10;
		
		// Exception 발생 -> 프로그램 비정상 종료
		
		try {
			// 문제가 되는 연산 자체를 try 안에 넣어야 함
			int result = num2/num1;
			System.out.println("결과 : " + result);
		} catch (ArithmeticException e) { 
			System.out.println("정수를 입력해야 합니다. ");
		}
		
		System.out.println("End");
	}

}
