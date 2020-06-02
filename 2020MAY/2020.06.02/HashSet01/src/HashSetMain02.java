import java.util.HashSet;

public class HashSetMain02 {

	public static void main(String[] args) {
		HashSet<Phone1> hs = new HashSet<Phone1>();
		// 주소 / equals로 비교하는 값 모두 같아야 두 객체가 '같다'고 판단한다.
		Phone1 p1 = new Phone1("010", 2000);
		Phone1 p2 = new Phone1("031", 21000);
		Phone1 p3 = new Phone1("070", 53000);
		
		// 값이 아니라 주소의 중복을 배제하는 듯. 예외처리를 해 줘야 한다.
		// src에서 간편하게 처리가 가능하다.
		Phone1 p4 = new Phone1("031", 21000);
		Phone1 p5 = new Phone1("070", 53000);
		
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		hs.add(p4);
		hs.add(p5);
		
		System.out.println(hs.size());
		System.out.println(hs.toString());
	}

}
