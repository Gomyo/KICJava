import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
		
		// java.util
		// Date
		// default Constructor - 현재 시스템 날짜
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.toString());
		System.out.println(d.toLocaleString());
		
		// 부분적인 method 사용
		System.out.println(d.getYear() + 1900);
		System.out.println(d.getMonth() + 1);
		System.out.println(d.getDate());
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(d.getSeconds());
		
		System.out.println(d.getDay());
		
		// 2020년 12월 25일의 요일을 알려면?
		Date nd = new Date(2020-1900, 12-1, 25);
		System.out.println(nd);
		
		// 2020년 12월 마지막 날의 요일은?
		Date fd = new Date(2021-1900, 1-1, 0);
		System.out.println(fd);
	}
}
