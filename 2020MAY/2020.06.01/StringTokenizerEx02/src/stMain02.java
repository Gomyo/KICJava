import java.util.StringTokenizer;

public class stMain02 {
	public static void main(String[] args) {
		String data = "사과&배&&&&복숭아";
		
		String[] datas = data.split("&");
		for (String s : datas) {
			System.out.println(s);
		}
		// StringTokenizer 공백이 없음
		StringTokenizer st = new StringTokenizer(data,"&");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
