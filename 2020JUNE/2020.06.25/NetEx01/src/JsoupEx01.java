import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEx01 {

	public static void main(String[] args) {
//		String strHtml = "<html><head><title>initial parse</title></head><body><p>Hello JSOUP</p></body></html>";
//		Document doc = Jsoup.parse(strHtml);
		// 폴더 내의 html 파일 가져오기
		Document doc = null;
		try {
			doc = Jsoup.parse(new File("./test.html"),"euc-kr");
			System.out.println(doc.toString());
			
			String title = doc.title();
			System.out.println(title);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
