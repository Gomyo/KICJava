package quiz;

import java.util.Scanner;

public class SearchDong {
	
	public String Dong() {
		Scanner s = new Scanner(System.in);
		System.out.println("동 이름을 입력하세요.");
		String dong = s.next();
		s.close();
		return dong;
	}
}
