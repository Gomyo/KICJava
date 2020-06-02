import java.util.ArrayList;

public class alMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 기본 buffer
		ArrayList arr1 = new ArrayList();
		// 100 buffer
		ArrayList arr2 = new ArrayList(100);
		
		arr1.add("OIOI");
		String str = "OIOI";
		
		// 자동 형변환이 되니까 아래처럼 쓰지 말고
//		Object obj = (Object)str; 
		// 걍 쓰기
		Object obj = str;
		arr1.add(obj);
		arr1.add("졸립다");
		System.out.println(arr1);
		System.out.println(arr1.size());
		
//		Object obj2 = arr1.get(0);
//		String rstr = (String)obj2;
//		String rstr = (String)arr1.get(0);
//		System.out.println(rstr);
//		System.out.println((String)arr1.get(2));
		
//		for (int i=0; i<arr1.size(); i++) {
//			System.out.println((String)arr1.get(i));
//		}

		// 특정 위치에 삽입
		arr1.add(2, "설중매");
		
		// 특정 위치를 수정
		arr1.set(0, "Adidas");

		for (Object o : arr1) {
			System.out.println((String)o);
		}
//		arr1.clear();
//		System.out.println(arr1.toString());
		System.out.println(arr1.indexOf("OIOI"));
		
	}

}
