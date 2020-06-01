import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2020년 2월 마지막 날의 요일 한글로
		Calendar c = Calendar.getInstance();
		c.set(2020, 3-1, 0);
		// 강사님 코드
//		String[] weekday = {"일","월","화","수","목","금","토"};
//		System.out.println(weekday[c.get(Calendar.DAY_OF_WEEK)-1]);
		
		// 내 코드
		String weekday = "일월화수목금토";
		System.out.println(weekday.charAt(c.get(Calendar.DAY_OF_WEEK)-1)+"요일");
		
		// 오 윤년 계산도 가능
		System.out.println(c.getActualMaximum(Calendar.DATE));
		System.out.println(c.getActualMinimum(Calendar.DATE));
	}

}
