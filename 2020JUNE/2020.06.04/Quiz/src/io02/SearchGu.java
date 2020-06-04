package io02;

import java.util.Scanner;

public class SearchGu {
	
	public String Gu() {
		Scanner s = new Scanner(System.in);
		System.out.println("구 이름을 입력하세요.");
		String gu = s.next();
		s.close();
		return gu;
	}
}
