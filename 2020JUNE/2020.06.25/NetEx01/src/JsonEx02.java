import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strJson = "{\"data\":[1,2,3,4,5]}";
		
		JSONParser parser = new JSONParser();
		
		
		try {
			//JSONParse에 데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
			JSONObject obj = (JSONObject)parser.parse(strJson);
			//JSONObject에서 array를 get해서 저장한다.
			JSONArray array = (JSONArray)obj.get("data");
			
			System.out.println(array);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
