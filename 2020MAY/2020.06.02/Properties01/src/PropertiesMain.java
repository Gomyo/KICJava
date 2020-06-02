import java.util.Enumeration;
import java.util.Properties;

public class PropertiesMain {
	public static void main(String[] args) {
		Properties props = new Properties();
		// 설정용 데이터
		props.setProperty("timeout", "30");
		props.setProperty("lang", "kr");
		props.setProperty("size", "10");
		
		System.out.println(props.getProperty("timeout"));
		System.out.println(props.getProperty("lang"));
		System.out.println(props.getProperty("size"));
		
		// 전체 데이터
		// Enumeration : Iterator의 구형 버전
		Enumeration e = props.propertyNames();
		while (e.hasMoreElements()) {
			System.out.println((String)e.nextElement());
		}
	}
}
