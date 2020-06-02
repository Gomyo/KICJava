import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Americano");
		hs.add("Espresso");
		hs.add("Cappuccino");
		System.out.println(hs.size());
		System.out.println(hs.toString());
		hs.add("Americano");
		hs.add("Espresso");
		hs.add("Cappuccino");
		// 값에 대한 중복이 제거되어 있음
		System.out.println(hs.size());
		System.out.println(hs.toString());
		
		// 값을 가져오는 두 가지 방법
		// 1. 향상된 for
		// 2. iterator
		Iterator<String> i = hs.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		for (String hss : hs) {
			System.out.println(hss);
		}
	}
}
