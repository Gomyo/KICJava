
public class ObjectEx02 {
	public static void main(String[] args) {
		Object o = new Object();
		
		// 주소값 출력됨
		System.out.println(o);
		
		// 주소값이 출력되는 원리는 무엇?
		// hash value
		System.out.println(o.getClass().getName());
		System.out.println(o.hashCode());
		
		// 16진수
		System.out.printf("%x%n",o.hashCode());
		
		// 그냥 이렇게 비교하면 주소(참조)의 비교이다.
		Object o1 = new Object();
		Object o2 = new Object();
		if (o1 == o2) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		// 주소의 비교(객체의 비교)와 값의 비교를 잘 구분하자.
		// 값을 비교하려면 equals를 쓴다.
		// 그런데 아까 값이 없으면 뭐라 했지? 참조 주소를 내놓는다고 했지? ㅇㅋ 그래서 또 false 뜸
		System.out.println(o1.equals(o2));
		
		// 그럼 값을 넣자. 
		String s1 = new String("Hi");
		String s2 = new String("Hi");
		// 주소값 비교는 역시 false!
		if (s1 == s2) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		// 값 비교는 참!
		System.out.println(s1.equals(s2));
	}
}
