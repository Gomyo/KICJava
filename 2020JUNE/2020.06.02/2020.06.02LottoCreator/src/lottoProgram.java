import java.util.HashSet;
import java.util.Scanner;

public class lottoProgram {
	// 6개씩 4세트 출력, random 사용
	// 중복제거 HashSet 사용
	public int lottoBuy() {
		Scanner s = new Scanner(System.in);
		System.out.println("구매하고 싶은 로또는 몇 장?");
		int lottoBuy = s.nextInt();
		s.close();
		return lottoBuy;
	}
	public void lottoCreate(int num) {
		for (int i=0; i<num; i++) {
			HashSet<Integer> lotto = new HashSet<Integer>();
			while (lotto.size()<6) {
				int n = (int)(Math.random()*45+1);
				lotto.add(n);
			}
			System.out.println(lotto);
		}
	}
}
