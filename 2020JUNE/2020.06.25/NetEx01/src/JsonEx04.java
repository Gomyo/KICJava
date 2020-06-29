import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonEx04 {

	public static void main(String[] args) {
		// 네트워크에 바로 연결해서 쓰는 방법
		
		String gangnamurl = "https://maps.googleapis.com/maps/api/geocode/json?address=%EC%84%9C%EC%9A%B8%EC%8B%9C%EC%B2%AD&key=AIzaSyBCEEd5naSLLZf1nDhpToFU_9MTyt1BdsY";

		BufferedReader br = null;
		JSONParser parser = new JSONParser();
		
		try {
			URL url = new URL(gangnamurl);
			URLConnection conn = url.openConnection();
			
			// 데이터 빨대 준비
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			// Json parser에 빨대 꽂기 (데이터의 형태를 잘 파악할 것. 위 주소의 데이터는 객체이니 JSONObject 사용)
			JSONObject obj = (JSONObject)parser.parse(br);
			// 위 단계에서 데이터 받아오는 것은 끝.
			
			// 1. 객체 results를 arr 형태로 받기
			JSONArray arr = (JSONArray)obj.get("results");
			// 2. arr에서 배열 하나만 선택해서 객체로
			JSONObject arrResult = (JSONObject)arr.get(0);
			// 3. 배열 하나에서 geometry 부분만 객체로
			JSONObject geometry = (JSONObject)arrResult.get("geometry");
			// 4. geometry 객체에서 location 부분만 객체로
			JSONObject location = (JSONObject)geometry.get("location");
			// 5. location에서 lat, lng만 받아오면 끝
			Double lat = (Double)location.get("lat");
			Double lng = (Double)location.get("lng");
			System.out.println(lat);
			System.out.println(lng);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
		}
	}

}
