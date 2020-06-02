import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTestMain {
	List<Object> list = new ArrayList<>();
	List<Integer> integers = Arrays.asList(1,2,3,4,5);
	
	public void createTest() {
		list.add("Hello");
		list.add("Hello"); // Add same data
		list.add(null); // Add null
		list.addAll(integers); // Add another collection elements
		list.add(integers); // Add another collection
		list.add(0, new Object()); // 끼워 넣기
		System.out.println("추가 후 내용 출력: "+list);
	}
	public void retrieveTest() {
		// 반복을 이용한 원소 조회
		for (int i=0; i<list.size(); i++) {
			System.out.println(i+" : "+list.get(i));
		}
		// 포함 여부의 활용
		if (list.contains("Hello")) {
			System.out.println("Hello is : "+list.indexOf("Hello"));
		}
		// 서브 리스트 활용
		List<Object> sub = list.subList(3, 5);
		System.out.println(sub);
		System.out.println("sub의 내용을 다 가지고 있는가?" + list.containsAll(sub));
	}
	public void updateTest() {
		list.set(1,"updated");
		System.out.println("Updated! "+list);
	}
	public void deleteTest() {
		list.remove(0); // 특정 위치의 객체 삭제
		list.remove("Hello"); // 특정 객체가 있다면 맨 처음으로 찾은 객체 삭제
		// 타입이 integer인 경우 삭제
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				list.remove(i);
			}
		}
		System.out.println("삭제 후 : "+list);
		list.clear(); // list 초기화
		System.out.println("초기화!: "+list);
	}
	public static void main(String[] args) {
		ArrayListTestMain alt = new ArrayListTestMain();
		alt.createTest();
		alt.retrieveTest();
		alt.updateTest();
		alt.deleteTest();
	}

}
