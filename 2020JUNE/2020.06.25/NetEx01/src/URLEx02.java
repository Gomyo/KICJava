import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		InputStream is = null;
		BufferedReader br = null;
		
		try {
			URL url = new URL("https://www.naver.com");
//			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			
//			int data = 0;
//			while ((data = br.read()) != -1) {
//				System.out.print((char)data);
//			}
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);				
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			if (is != null) try {is.close();} catch (IOException e) {}
			if (br != null) try {br.close();} catch (IOException e) {}
		}
		
	}

}
