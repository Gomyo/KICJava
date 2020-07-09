import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx02 {

	public static void main(String[] args) {
		Document doc = null;
		try {
			
			// html 요청방식 get/post => get은 url을 가져오고 post는 내부 헤더값을 가져온다.
			
//			doc = Jsoup.connect("https://www.naver.com").get();
			doc = Jsoup.connect("https://www.naver.com").post();
			// html doc 뽑기
//			System.out.println(doc.toString());
			
			// 제목 뽑기
//			String title = doc.title();
//			System.out.println(title);
			
			Element div = doc.getElementById("adscript");
			System.out.println(div.toString());
			
			// address 안에 있는 anchor<a> 가져오기
			Elements addresses = doc.getElementsByTag("address");
//			System.out.println(addresses.toString());
			for (Element address : addresses) {
				Elements anchors = address.getElementsByTag("a");
//				System.out.println(anchors.toString());
				for (Element anchor : anchors) {
					System.out.println(anchor.attr("href"));
					System.out.println(anchor.text());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
