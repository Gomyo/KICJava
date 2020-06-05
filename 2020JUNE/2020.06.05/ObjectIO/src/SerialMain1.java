import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialMain1 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./serial.dat"));
			
			Person p = new Person("홍길동","010-1111-1111",20);
			
			Person p1 = new Person("홍길동","010-1111-1111",20);
			Person p2 = new Person("홍","010-13341-1111",20);
			Person p3 = new Person("홍길","010-11908-1111",20);
			
			// 새로운 arraylist 생성
			ArrayList<Person> lists = new ArrayList<Person>(); 
			
			// ArrayList에 데이터 추가
			lists.add(p1);
			lists.add(p2);
			lists.add(p3);
			
			oos.writeObject(lists);
			
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
