
public class mathMain {
	public static void main(String[] args) {
		// static
		// 0 <=x <1
		System.out.println(Math.random()); // double -> int
		System.out.println(Math.random());
		
		// 0부터 9까지의 정수 추출
		System.out.println((int)(Math.random()*10));
		System.out.println((int)(Math.random()*10));
		
		// 1부터 45까지 정수 추출
		System.out.println((int)(Math.random()*45)+1);
	}
}
