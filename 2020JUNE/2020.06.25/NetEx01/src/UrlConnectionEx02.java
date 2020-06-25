import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionEx02 {

	public static void main(String[] args) {
//		https://t1.daumcdn.net/b2/creative/109475/4e9e6676f72090fc34e3283d53f90dbc.jpg
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			URLConnection conn = new URL("https://t1.daumcdn.net/b2/creative/109475/4e9e6676f72090fc34e3283d53f90dbc.jpg").openConnection();
			
			bis = new BufferedInputStream(conn.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream("./image.jpg"));
			
			int data = 0;
			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("다운로드 끝");
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bis != null) try {bis.close();} catch (IOException e) {}
			if (bos != null) try {bos.close();} catch (IOException e) {}
		}
	}

}
