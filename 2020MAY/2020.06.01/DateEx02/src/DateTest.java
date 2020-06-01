import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(d);
		Date d1 = new Date(1500000000000L);
		System.out.println(d1);
		long gap = d.getTime() - d1.getTime();
		System.out.printf("두 날짜의 차는 " + (gap/1000/60/60/24)+ "일이다");
	}

}
