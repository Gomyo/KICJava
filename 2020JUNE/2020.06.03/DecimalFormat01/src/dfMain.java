import java.text.DecimalFormat;
import java.text.ParseException;

public class dfMain {

	public static void main(String[] args) throws ParseException{
		double dorNum = 1234.5;
		DecimalFormat df = new DecimalFormat("￦#,###.#");
		System.out.println(df.format(dorNum));
		String dorStr = "￦1,234.5";
		// parse = 문자열을 숫자로 읽겠다
		// format = 숫자열을 문자로 읽겠다
		double parsed = (double)df.parse(dorStr);
		System.out.println(parsed);
	}

}
