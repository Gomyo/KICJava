import java.util.Date;

public class exepMain02 {
	private Date d;
	
	public static void main(String[] args) {
		exepMain02 ex2 = new exepMain02();
//		ex2.d = new Date();
		// NullPointerException
		try {
			System.out.println(ex2.d.toLocaleString());
		} catch (NullPointerException e) {
			System.out.println("새로운 객체가 생성되지 않았다.");
		}
	}

}
