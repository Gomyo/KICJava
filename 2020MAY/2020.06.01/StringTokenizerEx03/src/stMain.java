import java.util.StringTokenizer;

public class stMain {

	public static void main(String[] args) {
		String src = "이름:cjw,Java:100,HTML:99,JS:98";
		StringTokenizer st = new StringTokenizer(src, ": ,");
		System.out.println("All of tokens: "+st.countTokens());
		int sum=0;
		while (st.hasMoreTokens()) {
			String token = "";
			try {
				token = st.nextToken();
				sum += Integer.parseInt(token);
			} catch (NumberFormatException e) {
				System.out.println("It's not a number: "+token);
			}
		}
		System.out.println("sum: "+sum);
		
	}

}
