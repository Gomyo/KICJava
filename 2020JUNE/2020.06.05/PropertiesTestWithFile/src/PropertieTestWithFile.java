import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

public class PropertieTestWithFile {
	private final static String path = "./config.properties";
	
	private static void saveToFile() {
		Properties props = new Properties();
		props.setProperty("id", "andy");
		props.setProperty("pass", "1234");
		props.setProperty("ip", "192.168.0.1");
		props.setProperty("이름", "홍길동");
		System.out.println("속성 확인 : "+ props);
		
		try (FileWriter fw = new FileWriter(path)) {
			props.store(fw, "System config");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void loadFromFile() {
		Properties props = new Properties();
		try (FileReader fr = new FileReader(path)) {
			props.load(fr);
			Set<String> keys = props.stringPropertyNames();
			for (String key : keys) {
				System.out.println(key + " : "+props.getProperty(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		saveToFile();
		loadFromFile();
	}
}
