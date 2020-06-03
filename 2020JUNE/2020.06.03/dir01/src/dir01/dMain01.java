package dir01;

import java.io.File;

public class dMain01 {

	public static void main(String[] args) {
		File f = new File("c:/java");
		/*
		String[] lists = f.list();
		for (String i : lists) {
			File sub = new File("c:/java",i);
			if (sub.isDirectory()) {
				System.out.println("["+ i + "]");
			}
			else {
				System.out.println(i);
			}
//			System.out.println(i);
		}
		*/
		
		File[] lists = f.listFiles();
		for (File list : lists) {
			if (list.isFile()) {
				System.out.println(list.getName());
			}
			else {
				System.out.println("["+ list.getName() + "]");
			}
		}
	}

}
