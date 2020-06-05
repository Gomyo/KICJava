import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialMain2 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("./serial.dat"));
			

			ArrayList<Person> lists = (ArrayList<Person>)ois.readObject();
			
			for (Person p : lists) {
				System.out.println(p.getName());
				System.out.println(p.getPhone());
				System.out.println(p.getAge());
			}
			
			/*
			Person p = (Person)ois.readObject();
			System.out.println(p.getName());
			System.out.println(p.getPhone());
			System.out.println(p.getAge());
			*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) try {ois.close();} catch (IOException e) {}
		}
	}
}
