package dir01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class dMain03 {

	public static void main(String[] args) {
		File f = new File("../../ZionT");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1 to create folder, or else to delete");
		int a = s.nextInt();
		
		if (a==1) {
			if (f.mkdir()) {
				System.out.println("Success");
			}
			else {
				System.out.println("Folder already created");
			}
		}
		else {
			if (f.delete()) {
				System.out.println("Success");
			}
			else {
				System.out.println("Folder already deleted");
			}
		}
		
		File f2 = new File("../../ICIS.csv");
		try {
			if (f2.createNewFile()) {
				System.out.println("Success");
			}
			else {
				System.out.println("File already created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
