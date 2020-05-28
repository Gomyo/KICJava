
public class initCapFinal {

	void toCap(String x) {
		String [] tmp = x.split(" ");
		
		int i = 0;
		for (String t : tmp) {
			tmp[i] = t.substring(0,1).toUpperCase().concat(t.substring(1));
			i++;
		}
		System.out.println(String.join(" ", tmp));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initCapFinal ic = new initCapFinal();
		ic.toCap("hong gil dong");
	}

}