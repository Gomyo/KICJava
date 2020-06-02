
public class ObjectEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = new Object();
		// 주소(자료형@참조주소)
		
		// 객체변수 => toString()
		System.out.println(o);
		// 객체의 내부 내용 표시 메서드
		// 내부 자료가 없다면 주소값이 나온다~
		System.out.println(o.toString());
		// Overriding
		String s = new String("String");
		System.out.println(s.toString());
		
		Person p = new Person("Harry Potter", 20);
		System.out.println(p);
		System.out.println(p.toString());
		
		System.out.println(p.viewAllData());
	}

}
