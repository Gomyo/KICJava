import com.example.Person;

public class MainEx01 {
	public static void main(String[] args) {
		// Ctrl + Shift + O : Auto import
		Person p = new Person();
//		p.name = "JOOONNNN";
//		System.out.println(p.name);
		
		Person pp = new Person("최준원", 26, 182.3);
		System.out.println(pp.getName());
		System.out.println(pp.getAge());
		System.out.println(pp.getHeight());
	}
}
