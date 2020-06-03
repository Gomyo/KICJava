package file01;

import java.io.File;
import java.util.Date;

public class fMain03 {

	public static void main(String[] args) {
		File f = new File("c:/Java/test.txt");
		if (f.isHidden()) {
			System.out.println("hidden");
		} else {
			System.out.println("Normal");
		}
		File f1 = new File("c:/java/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip");
		// 파일의 크기 (byte)
		long filesize = f1.length();
		System.out.println(filesize + "Byte");
		System.out.println(Math.round(filesize/1024.) + "KB");
		
		long filedate = f1.lastModified();
		System.out.println(filedate);
		// Unix time to date 하는 법
		System.out.println(new Date(filedate).toLocaleString());
	}

}
