import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonEx01 {

	public static void main(String[] args) {
		String json = "[ { \"name\":\"홍길동\", \"city\":\"서울\"},{ \"name\":\"아이린\", \"city\":\"레드벨벳\"} ]";
		
		JSONParser parser = new JSONParser();
		
		JSONArray array;
		try {
			array = (JSONArray)parser.parse(json);
			System.out.println(array.size());
			
			for (int i=0; i<array.size(); i++) {
				JSONObject obj = (JSONObject)array.get(i);
				
				System.out.println((String)obj.get("name"));
				System.out.println((String)obj.get("city"));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
