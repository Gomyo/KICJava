
public class initCapEx02 {
	
	void toCap(String x) {
		String [] tmp = x.split(" ");
		String [] result = new String[tmp.length];
		
		int i = 0;
		for (String t : tmp) {
			String t1 = t.substring(0,1).toUpperCase().concat(t.substring(1));
			result[i] = t1;
			i++;
		}
		System.out.println(String.join(" ", result));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initCapEx02 ic = new initCapEx02();
		ic.toCap("hong gil dong");
	}

}