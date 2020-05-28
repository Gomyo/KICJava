
public class MainEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Eclipse");
		
		Person p1 = new Person(); // Default Constructor
		Person p2 = new Person("1001", "초이주노언"); 
		
		System.out.println(p2.getHakbun());
		System.out.println(p2.getName());
	}
}
