import java.util.ArrayList;
import java.util.HashMap;

public class alMain04 {

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
		
		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("name","홍길동");
		hm1.put("age","20");
		HashMap<String, String> hm2 = new HashMap<String, String>();
		hm2.put("name","고길동");
		hm2.put("age","30");
		HashMap<String, String> hm3 = new HashMap<String, String>();
		hm3.put("name","명동으로갈까요호");
		hm3.put("age","40");
		
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String,String>>();
		al.add(hm1);
		al.add(hm2);
		al.add(hm3);
		System.out.println("------------------------------");
		for (HashMap<String, String> hm : al) {
			System.out.println(hm.get("name"));
			System.out.println(hm.get("age"));
		}
		
	}
}