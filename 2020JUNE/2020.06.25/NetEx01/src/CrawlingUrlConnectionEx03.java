import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CrawlingUrlConnectionEx03 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		try {
			URLConnection conn = new URL("https://www.daum.net/?t__nil_top=refresh").openConnection();
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("<ul class=\"list_txt\">")) {
					while(true) {
						String htmlLine = br.readLine();
						// </ul> 태그 이전까지 크롤링
						if (!htmlLine.equals("</ul>")) {
							System.out.println(htmlLine);
						} else {
							break;
						}
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
		}
	}
}
