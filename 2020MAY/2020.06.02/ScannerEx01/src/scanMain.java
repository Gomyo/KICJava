import java.util.Scanner;

public class scanMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("값을 입력. 마치려면 q");
		String msg = "";
		
		while (true) {
			System.out.print("입력 : ");
			msg = s.nextLine();
//			if (msg.equals("q") || msg.equals("Q") ) {
			if (msg.equalsIgnoreCase("q")) {
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("입력 메시지 : " + msg);
			}
		}
		s.close();
	}
}
