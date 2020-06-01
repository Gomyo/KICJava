import java.util.Scanner;

public class JuminCheckTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("주민등록번호 입력('-'하이픈 포함): ");
		String j = s.next();
		
		String jumin = j.substring(0, 6).concat(j.substring(7,13));
		String check = "234567892345";
		int sum = 0;
		System.out.println(jumin);
		// charAt은 parseInt 사용 불가능. substring으로 뽑아와야 함
		for (int i=0; i<jumin.length(); i++) {
			sum += Integer.parseInt(check.substring(i,i+1)) * Integer.parseInt(jumin.substring(i,i+1));
			System.out.println(sum);
		}
		int result = (11-(sum%11)) % 10;
		System.out.println(result);
		if (result == 0) {
			System.out.println(true);
		}			
		
	}

}
