import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingQuiz {

	public static void main(String[] args) {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.daum.net").post();
			Elements linktxt = doc.getElementsByClass("link_txt");
//			System.out.println(linktxt.toString());
			for (Element txt : linktxt) {
				System.out.println(txt.text());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
