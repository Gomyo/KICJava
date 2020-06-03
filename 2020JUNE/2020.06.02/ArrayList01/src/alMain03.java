import java.util.ArrayList;

public class alMain03 {
	public static void main(String[] args) {
		String str1 = "Ga";
		String str2 = "Na";
		String str3 = "Da";
		
		// Not Generic
		ArrayList al1 = new ArrayList();
		al1.add(str1);
		al1.add(str2);
		al1.add(str3);
		for (Object o : al1) {
			System.out.println((String)o);
		}
		
		System.out.println("--------------------");
		
		// Generic
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add(str1);
		al2.add(str2);
		al2.add(str3);
		for (String s : al2) {
			System.out.println(s);
		}
		System.out.println("--------------------");
		
		
		Person p1 = new Person("Ga", 20);
		Person p2 = new Person("Na", 30);
		Person p3 = new Person("Da", 40);
		
		// Generic
		ArrayList<Person> al3 = new ArrayList<Person>();
		al3.add(p1);
		al3.add(p2);
		al3.add(p3);
		
		for (Person p : al3) {
			System.out.println(p.getName());
			System.out.println(p.getAge());
		}
	}
}
