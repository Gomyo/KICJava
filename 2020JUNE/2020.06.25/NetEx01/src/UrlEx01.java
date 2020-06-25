import java.net.MalformedURLException;
import java.net.URL;

public class UrlEx01 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.naver.com:8080/sample/hello.html?key1=value1&key2=value2");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
