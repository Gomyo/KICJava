
public class ObjectEx01 {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		
		if (a == b) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		String s1 = "Hello";
		String s2 = "Hello";
		if (s1 == s2) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println(s1.equals(s2) ? "true":"false");
		
		String s3 = new String("Bye");
		String s4 = new String("Bye");
		
		System.out.println(s3 == s4 ? "true":"false"); // 주소값이 다름
		System.out.println(s3.equals(s4)?"true":"false");
		
	}
}
