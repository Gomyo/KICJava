import java.util.StringTokenizer;

public class StringTokenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "사과 배 복숭아";
		StringTokenizer st = new StringTokenizer(data);
		
//		System.out.println(st.countTokens());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.hasMoreTokens());
//		System.out.println(st.nextToken());
//		System.out.println(st.hasMoreTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		data = "사과&배&복숭아";
		st = new StringTokenizer(data,"&");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		
	}

}
