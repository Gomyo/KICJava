import java.util.Calendar;

public class DateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.set(2019, 2-1, 1);
//		System.out.println(c.toString());
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DATE));
		// 일요일 : 1
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}

}
