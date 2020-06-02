import java.util.Enumeration;
import java.util.Properties;

public class PropertiesMain02 {
	public static void main(String[] args) {
		// System에 설정된 환경값 가져오기
		Properties props = System.getProperties();
		Enumeration e = props.propertyNames();
		// Java와 관련된 속성 설정값 출력
		while (e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = props.getProperty(key);
			System.out.println(key+":"+value);
		}
	}
}
