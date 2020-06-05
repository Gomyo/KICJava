package quiz;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		BufferedWriter bw = null;
		BufferedOutputStream bos = null;
		
		SearchGu s = new SearchGu();
		String d = s.Gu();
//		String d = "강남";
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul.csv"));
			String info = null;
			
			
			// 폴더 생성
			while ((info = br.readLine()) != null) {
				String[] infos = info.split(",");
				if (infos[2].contains(d)) {
					// 파일도 true로 이어서 만들었어야지!!!!!! 해결이다!
					bos = new BufferedOutputStream(new FileOutputStream("C:\\Java\\KICeclipse\\2020JUNE\\2020.06.04\\2020.06.04Quiz\\"+infos[3]+".txt",true));
					// 이어쓰기 위해 true 옵션
					bw = new BufferedWriter(new FileWriter("C:\\Java\\KICeclipse\\2020JUNE\\2020.06.04\\2020.06.04Quiz\\"+infos[3]+".txt",true));
//					bw = new BufferedWriter(new FileWriter(bos)); 
					// Q :위에서 bos를 선언했기에 되는 줄 알았는데 왜 안되지?
					// A :걍 Java는 안된다. 깡 주소를 써야 함!
					
					// String을 계속 추가해 줘야 함.
//					info += info; 이러면 같은 값만 중복됨 
					bw.write(infos[0]+"\t");
					bw.write(infos[1]+"\t");
					bw.write(infos[2]+"\t");
					bw.write(infos[3]+"\t");
					bw.write(infos[4]+"\t");
					bw.write(infos[5]+"\t");
					bw.write(infos[6]+"\n");
					bw.close(); // 작성하고 계속 닫아줘야 함! 닫아주지 않으면 계속 열려있어서 데이터가 계속 날아가게 된다.
					// TODO :문제! 이렇게 하면 개포1동에 해당하는 가장 마지막 줄만 저장됨 (해결 : 내용에만 true가 아니라 파일도 true 옵션을 지정해 줘야 함)
				}
			}
//			System.out.println(infos[3]+"폴더가 생성되었습니다.");
//			System.out.println(info + "작성이 완료되었습니다.");
//			// 파일 쓰기
//			while ((info = br.readLine()) != null) {
//				String[] infos = info.split(",");
//				PrintWriter pw = new PrintWriter("C:/Java/2020.06.04/"+infos[3]+".txt");
//				pw.write(info);	
//				pw.close();
//			}
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
