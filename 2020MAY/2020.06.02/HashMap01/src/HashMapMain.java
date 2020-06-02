import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("a", "가롱이");
		hm1.put("b", "세롱이");
		hm1.put("c", "대각롱이");
		
		hm1.put("c", "Hololololo");
		hm1.put("d", "갑분싸");

		System.out.println(hm1.size());
		System.out.println(hm1.toString());
		
		System.out.println(hm1.get("a"));
		System.out.println(hm1.get("b"));
		System.out.println(hm1.get("c"));
		System.out.println("----------------------------");
		// key 추출
		System.out.println(hm1.keySet());
		System.out.println("----------------------------");
		Set<String> keys = hm1.keySet();
		
		System.out.println(keys);
		System.out.println("----------------------------");
		for (String k : keys) {
			System.out.println(k + " : "+ hm1.get(k));
		}
		System.out.println("----------------------------");
		
		System.out.println(hm1.entrySet());
		
		System.out.println("----------------------------");
		// value만 추출
		System.out.println(hm1.values());
		System.out.println("----------------------------");
		Collection<String> values = hm1.values();
		for (String v : values) {
			System.out.println(v);
		}
	}
}
