import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sdftMain {

	public static void main(String[] args) throws ParseException {
		String src = "2020년 12월 25일";
		System.out.println(src + "를 요일 정보까지 출력하즈아");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date parsed = f.parse(src);
		f.applyPattern("yyyy년 MM월 dd일(E)");
		System.out.println(f.format(parsed));
	}

}
