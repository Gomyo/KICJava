package file01;

import java.io.File;

public class fMain01 {

	public static void main(String[] args) {
		// File 객체 생성
		
		// 디렉토리용 파일 객체
		File f1 = new File("c:/Java");
		
		// 파일용 파일 객체
		File f2 = new File("c:/Java/test.txt");
		
		if (f1.isDirectory()) {
			System.out.println("DIR");
		}
		else {
			System.out.println("FILE");
		}
		if (f2.isDirectory()) {
			System.out.println("DIR");
		}
		else {
			System.out.println("FILE");
		}
		
		// exist : 존재하는지 묻는 메서드
		File f3 = new File("c:/Java/test2.txt");
		if (f3.exists()) {
			System.out.println("있음");
		}
		else {
			System.out.println("없음");
		}
	}

}
