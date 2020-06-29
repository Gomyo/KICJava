import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonEx03 {

	public static void main(String[] args) {
		String strJson = "{\"id\": 123,\"name\": \"Pankaj Kumar\",\"permanent\": true,\"address\": [{\"street\": \"El Camino Real\",\"city\": \"San Jose\",\"zipcode\": \"95014\"}] ,\"phoneNumbers\": [\"9988664422\", \"1234567890\"],\"role\": \"Developer\"}";
		JSONParser parser = new JSONParser();
		
		try {
			// Reader로 바로 읽어오기
			JSONObject obj = (JSONObject)parser.parse(new FileReader("C:\\Coding\\json data.txt"));
			
//			System.out.println(obj.toString());
//			System.out.println(obj);
			
			JSONArray arr = (JSONArray)obj.get("address");
			for (int i=0; i<arr.size(); i++) {
				JSONObject result = (JSONObject)arr.get(i);
				System.out.println((String)result.get("zipcode"));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
