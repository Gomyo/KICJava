package io02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class postaddressSearcher {

	public static void main(String[] args) {
		/*
		java SearchDong 개포 
		[우편번호] 주소 
		개포로 시작하는 동
		동이름을 입력않으면 에러메시지와 동시에 프로그램 종료
		*/
		BufferedReader br = null;
		
		SearchDong s = new SearchDong();
		String d = s.Dong();
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
			String info = null;
			while ((info = br.readLine())!=null) {
				String[] infos = info.split(",");
				/*
				 * 문자열 비교
				 * startWith
				 * endWith
				 * contains
				 * equals
				 * */
				if (infos[3].contains(d)) {
					System.out.printf("[%s]  %s %s %8s %20s\n",infos[0],infos[1],infos[2],infos[3],infos[5]);
				}
				/*if ~
				 * sysout(String.join(" ",infos)도 가능함.
				 * */
			}
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

}
