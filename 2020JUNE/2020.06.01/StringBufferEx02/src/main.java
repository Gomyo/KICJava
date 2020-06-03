
public class main {
	public void checkSpeed1() {
		long start = System.currentTimeMillis();
		String x = "";
		for (int i=0; i<10_000; i++) {
			x += "aaaaaaaaa";
		}
		System.out.println(x.length());
		System.out.println("speed1" + (System.currentTimeMillis() - start));
	}
	public void checkSpeed2() {
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<10_000; i++) {
			sb.append("aaaaaaaaa");
		}
		System.out.println(sb.length());
		System.out.println("speed2" + (System.currentTimeMillis() - start));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main m = new main();
		m.checkSpeed1();
		m.checkSpeed2();
	}

}
