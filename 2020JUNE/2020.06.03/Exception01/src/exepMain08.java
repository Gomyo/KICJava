import java.text.DecimalFormat;
import java.text.ParseException;

public class exepMain08 {

	public static void main(String[] args) {
		double dorNum = 1234.5;
		DecimalFormat df = new DecimalFormat("￦#,###.#");
		System.out.println(df.format(dorNum));
		String dorStr = "￦1,234.5";
		// parse = 문자열을 숫자로 읽겠다
		// format = 숫자열을 문자로 읽겠다
		// 여기 parse에 parseException이 위임되어 있음
		try {
			double parsed = (double)df.parse(dorStr);
			System.out.println(parsed);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
