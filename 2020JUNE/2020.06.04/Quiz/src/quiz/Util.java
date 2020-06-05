package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Util {
	
	public void searchZipcode(String strGu) {
		BufferedReader br = null;
		
		SearchGu s = new SearchGu();
		String d = s.Gu();
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
			
			String info = null;
			while ((info = br.readLine()) != null) {
				String[] infos = info.split(",");
				info = br.readLine();
				if (infos[2].contains(d)) {
				}
			}
			System.out.println("폴더가 생성되었습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("[에러] : "+e.toString());
		} catch (IOException e) {
			System.out.println("[에러] : "+e.toString());
		} catch (NoSuchElementException e) {
			System.out.println("[에러] : "+e.toString());
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
		}
	}
	
	// Exception 위임
	public void searchZipcode2(String strGu) throws FileNotFoundException, IOException {
		BufferedReader br = null;
		
		SearchGu s = new SearchGu();
		String d = s.Gu();
		
		br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
		String info = null;
		while ((info = br.readLine()) != null) {
			String[] infos = info.split(",");
			if (infos[2].contains(d)) {
				infos[0] = "[" + infos[0] + "]";
				System.out.println(String.join(" ", infos));
			}
		}
		br.close();
	}
	
	public StringBuffer searchZipcode3(String strGu) throws FileNotFoundException, IOException {
		BufferedReader br = null;
		
		SearchGu s = new SearchGu();
		String d = s.Gu();
		
		br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
		String info = null;
		StringBuffer result = new StringBuffer();
		while ((info = br.readLine()) != null) {
			String[] infos = info.split(",");
			if (infos[2].contains(d)) {
				infos[0] = "[" + infos[0] + "]";
				//System.out.println(String.join(" ", infos));
				// elements 마지막에 엔터키를 하나 넣어야 함
				// result+= String.join(" ", infos) + "\n"; - public String일 때
				result.append(String.join(" ", infos )+"\n");
			}
		}
		br.close();
		
		return result;
	}
	public ArrayList<Zipcode> searchZipcode4(String strGu) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
		SearchGu s = new SearchGu();
		String d = s.Gu();
		
		String info = null;
		ArrayList<Zipcode> result = new ArrayList<Zipcode>();
		while ((info = br.readLine()) != null) {
			String[] infos = info.split(",");
			if (infos[2].contains(d)) {
				// 메서드에서 교정하지 말고 출력하는 main에서 출력하는게 나음
//				infos[0] = "[" + infos[0] + "]";
				Zipcode zipcode = new Zipcode();
				zipcode.setCode(infos[0]);
				zipcode.setSido(infos[1]);
				zipcode.setGugun(infos[2]);
				zipcode.setDong(infos[3]);
				zipcode.setRi(infos[4]);
				zipcode.setBunji(infos[5]);
				zipcode.setSeq(infos[6]);
				result.add(zipcode);
			}
		}
		br.close();
		return result;
	}
}
