import java.util.StringJoiner;

public class sjMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String to String
		// 문자열 연결
		String str1 = "banana" + "apple" + "grepe" + "kiwi";
		System.out.println(str1);
		
		// format
		String str2 = String.format("%s,%s,%s,%s", "kiwi","pineapple","apple","plum");
		System.out.println(str2);
		
		// Array to String
		String[] arr = {"banana","apple","grepe","kiwi"};
		String str3 = String.join(",", arr);
		System.out.println(str3);
		
		// 클래스화 시켜서 쓰기
		StringJoiner sj = new StringJoiner(",");
		sj.add("1");
		sj.add("2");
		sj.add("3");
		sj.add("4");
		// Same as toString
		System.out.println(sj);        
		System.out.println(sj.toString());
	}

}
