package file01;

import java.io.File;

public class fMain02 {

	public static void main(String[] args) {
		
		// 절대경로 방식
//		File f = new File("c:/Java/test.txt");
		
		// 상대경로 방식
		File f = new File("../../test.txt");
		
		// 경로에 대한 정보
		System.out.println(f.getName());
		System.out.println(f.getParent());
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		try {
			// 상대 -> 절대
			System.out.println(f.getCanonicalPath());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
