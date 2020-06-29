import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GoogleReadEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=강남역&key=AIzaSyBCEEd5naSLLZf1nDhpToFU_9MTyt1BdsY");
			URLConnection conn = url.openConnection();
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = null;
			String lat = null;
			String lng = null;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//				if (line.contains("lat") || line.contains("lng")) {
//					System.out.println(line);
//				}
				if (line.contains("\"location\"")) {
					// location 밑에 두줄을 더 읽으면 된다는 발상
//					System.out.println(br.readLine());
//					System.out.println(br.readLine());
					lat = br.readLine().trim().substring(8).replace(",", "");
					lng = br.readLine().trim().substring(8).replace(",", "");
				}
				
			}
			System.out.println("위도 : " + lat);
			System.out.println("경도 : " + lng);
			
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
