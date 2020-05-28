public class initCapEx01 {
	void toCap(String x) {
		String [] tmp = x.split(" ");
		String result = "";
		
		for (String t : tmp) {
			String t1 = t.substring(0,1).toUpperCase().concat(t.substring(1));
			result += t1 + " ";
		}
		System.out.println(result);
		System.out.println(result.length());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initCapEx01 ic = new initCapEx01();
		ic.toCap("hong gil dong");
	}

}
