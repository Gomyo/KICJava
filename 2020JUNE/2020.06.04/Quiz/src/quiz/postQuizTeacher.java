package quiz;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class postQuizTeacher {

	public static void main(String[] args) {
		String strGu = "강서";
		
		Util u = new Util();
		
		try {
//			StringBuffer result = u.searchZipcode3(strGu);
//			System.out.println(result.toString());
			
			ArrayList<Zipcode> zipcodes = u.searchZipcode4(strGu);
			for (Zipcode zipcode : zipcodes) {
				System.out.println("[ "+zipcode.getCode()+" ]");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("[에러처리] "+e.getMessage());
		} catch (IOException e) {
			System.out.println("[에러처리] "+e.getMessage());
		}
	}
}