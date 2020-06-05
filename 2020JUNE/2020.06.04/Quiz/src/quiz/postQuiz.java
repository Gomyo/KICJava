package io02;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

public class postQuiz {

	public static void main(String[] args) {
		// 강남구 라고 입력하면
		// 동 별로 나누어서 txt 파일로 저장하기
		BufferedReader br = null;
		BufferedOutputStream bos = null;
		BufferedWriter bw = null;
		
		SearchGu s = new SearchGu();
		String d = s.Gu();
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
			
			String info = null;
			
			// 폴더 생성
			while ((info = br.readLine()) != null) {
				String[] infos = info.split(",");
				info = br.readLine();
				if (infos[2].contains(d)) {
					bos = new BufferedOutputStream(new FileOutputStream("c:/Java/2020.06.04Quiz/"+infos[3]+".txt"));
					bw = new BufferedWriter(new FileWriter("c:/Java/2020.06.04Quiz/"+infos[3]+".txt"));
					System.out.println(bw.toString());
					bw.write("acaca");
//					System.out.println(f.toString());
//					bw = new BufferedWriter(new FileWriter(f,true));
//					bw.write(info);
//					bw.flush();
				}
			}
			System.out.println("폴더가 생성되었습니다.");
			
//			// 파일 쓰기
//			while ((info = br.readLine()) != null) {
//				String[] infos = info.split(",");
//				PrintWriter pw = new PrintWriter("C:/Java/2020.06.04/"+infos[3]+".txt");
//				pw.write(info);	
//				pw.close();
//			}
			System.out.println("작업이 완료되었습니다.");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("[에러] : "+e.toString());
		} catch (IOException e) {
			System.out.println("[에러] : "+e.toString());
		} catch (NoSuchElementException e) {
			System.out.println("[에러] : "+e.toString());
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
			if (bw != null) try {bw.close();} catch (IOException e) {}
		}
	}

}
