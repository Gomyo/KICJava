import java.util.ArrayList;

public class alMain02 {

	public static void main(String[] args) {
		Person p1 = new Person("Ga", 20);
		Person p2 = new Person("Na", 30);
		Person p3 = new Person("Da", 40);
		
		ArrayList al1 = new ArrayList();
		
		al1.add(p1);
		al1.add(p2);
		al1.add(p3);
		
		Person p = (Person)al1.get(2);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
		for (Object o : al1) {
			Person po = (Person)o;
			System.out.println(po.getName());
			System.out.println(po.getAge());
		}
	}

}
