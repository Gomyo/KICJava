package dir01;

import java.io.File;
import java.util.Date;

public class dMain02 {

	public static void main(String[] args) {
		File f = new File("../");
		if (f.exists()) {
			File[] lists = f.listFiles();
			for (File list : lists) {
				Date d = new Date(list.lastModified());
				String name = list.getName();
				long length = list.length();
				if (list.isDirectory()) {
					name = "["+ list.getName() + "]";
				}
				System.out.printf("%-60s\t%tF %<tT\t%s%n", name,d,length);
			}
		}
	}

}
