import java.util.Random;

public class exepMain05 {

	public static void main(String[] args) {
		int num = new Random().nextInt(2);
		try {
			System.out.println("code 1, num: "+ num);
			int i = 1/num;
			System.out.println("Code 2 - no exception");
			return;
		} catch (ArithmeticException e) {
			System.out.println("Code 3 - Exception Success");
		} finally {
			System.out.println("항솽 쉴횅");
		}
		System.out.println("에러가 발생했었군");
	}

}
