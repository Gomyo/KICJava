import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectIOMain01 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./data.dat"));
			
			String[] names = {"chi","oh","Nah"};
			int[] ages = {55,23,47};
			
			oos.writeObject(names);
			oos.writeObject(ages);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) try {oos.close();} catch (IOException e) {}
		}
		
		System.out.println("Print Success");
	}

}
