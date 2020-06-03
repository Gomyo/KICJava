
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer();
		
		// Buffer 용량 100
		StringBuffer sb2 = new StringBuffer(100);
		
		// 데이터를 넣어서 만들 수도 있음
		StringBuffer sb3 = new StringBuffer("Hello Buffer!");
		
		// buffer 용량 체크
		System.out.println(sb1.capacity()); // 기본값 16
		System.out.println(sb2.capacity()); // 정해줌
		System.out.println(sb3.capacity()); // 데이터가 들어가면 데이터에 16을 더함
		
		// buffer 내용의 길이
		System.out.println(sb1.length());
		System.out.println(sb2.length());
		System.out.println(sb3.length());
		
		// charAt 인덱스에 해당하는 문자열 반환
		// substring
		// indexOf
		// replace
		
		// append / insert / delete 내부 문자 변경 메서드
		System.out.println(sb3.toString());
		sb3.append("안녕");
		System.out.println(sb3);
		sb3.insert(3, "추가");
		System.out.println(sb3);
		sb3.delete(2, 5);
		System.out.println(sb3);
		sb3.reverse();
		System.out.println(sb3);
	}

}
