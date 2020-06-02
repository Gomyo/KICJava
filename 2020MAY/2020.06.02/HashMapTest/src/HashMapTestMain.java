import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTestMain {
	Map<String, String> hm = new HashMap<String, String>();
	
	private void addMethod() {
		System.out.println("추가 : "+hm.put("zzZ", "1234"));
		System.out.println("추가 : "+hm.put("zzZ", "4567"));
		hm.put("henry", "4567");
		hm.put("kite", "9999");
		System.out.println(hm);
	}
	
	private void retrieveMethod() {
		System.out.println("총 Entity 개수 :" + hm.size());
		Set<String> keys = hm.keySet();
		for (String k : keys) {
			System.out.println("key : "+ k + ", value : "+ hm.get(k));
		}
		String targetNumber = "4567";
		Set<Map.Entry<String, String>> entrySet = hm.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {
			if (entry.getValue().equals(targetNumber)) {
				System.out.println("번호가 "+targetNumber+"인 사람: "+entry.getKey());
			}
		}
		System.out.println("kite의 전화번호는 있음??? "+hm.containsKey("kite"));
	}
	private void removeMethod() {
		hm.remove("zzZ");
		System.out.println(hm);
	}
	
	public static void main(String[] args) {
		HashMapTestMain hmtm = new HashMapTestMain();
		hmtm.addMethod();
		hmtm.retrieveMethod();
		hmtm.removeMethod();
	}

}
