import java.util.Random;

public class lottomain {
	public static void main(String[] args) {
		//Random r = new Random();
		// 뽑을 때마다 다른 파일을 뽑을거라는 의미. seeding
		Random r = new Random(System.currentTimeMillis());
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=6; j++) {
				System.out.printf("%2d   ",r.nextInt(45)+1);
			}
			System.out.println();
		}
	}
}
