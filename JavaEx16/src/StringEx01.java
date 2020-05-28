
public class StringEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello World";
		String str2 = new String("Hello World");
		char[] charArr = {'H','E','L'};
		String str3 = new String(charArr);
		
		System.out.println(str3.length());
		
		// 문자열에서 문자 추출
		char chr1 = str1.charAt(0);
		System.out.println(chr1);
		
		// 문자열에서 문자열 추출
		String substr1 = str1.substring(1, 5);
		System.out.println(substr1);
		
		// 문자 / 문자열 검색 - 위치 반환
		int idx1 = str1.indexOf("ll");
		System.out.println(idx1);
		// 마지막 인덱스 찾기
		int idx2 = str1.lastIndexOf("o");
		System.out.println(idx2);
		// 두 경우 모두 아무것도 없으면 -1
		
		// 문자열의 존재
		boolean b1 = str1.startsWith("he");
		System.out.println(b1);
		
		// 문자열 치환
		String rstr1 = str1.replaceAll("o World", " Chosen");
		// str1 자체를 바꾸는 것이 아님! immutable임을 기억
		System.out.println(rstr1);
		
		// 문자열 결합 (+)
		String jstr1 = str1.concat("안녕");
		String jstr2 = jstr1.concat("Hello");
		System.out.println(jstr2);
		
		// 대소문자 변환
		System.out.println("hello".toUpperCase());
		System.out.println("heLLLLlo".toLowerCase());
		
		// 좌우공백제거
		String tstr = "              Hlloe da      ";
		System.out.println(tstr.length());
		String tdstr = tstr.trim();
		System.out.println(tdstr.length());
		
		// 문자열 분리
		String sStr = "apple,banana,chamwoe";
		String[] strArray1 = sStr.split(",");
		
		// 향상된 for문으로 출력
		for ( String s : strArray1) {
			System.out.println(s);
		}
		
		// 문자열 연결
		String jstr = String.join("", strArray1);
		System.out.println(jstr);
		
	}

}
