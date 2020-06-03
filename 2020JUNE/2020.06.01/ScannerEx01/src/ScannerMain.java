import java.util.Scanner;

public class ScannerMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("IFRYUK: ");
//		String msg = s.next();
		// 한 줄 전체를 다 받으려면
		String msg = s.nextLine();
		
		// 입력받은 문자열 처리
		
		System.out.println("IFRYUKGAF: " + msg);
		s.close();
	}
}
