import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIOMain02 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("./data.dat"));
			
			String[] names = (String[])ois.readObject();
			int[] ages = (int[])ois.readObject();
			
			for (String name: names) {
				System.out.println(name);
			}
			System.out.println(String.join(" ", names));
			for (int age: ages) {
				System.out.println(age);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) try {ois.close();} catch (IOException e) {}
		}
	}
}
