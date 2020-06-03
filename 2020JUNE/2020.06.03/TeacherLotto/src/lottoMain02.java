import java.util.HashSet;
import java.util.Random;

public class lottoMain02 {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random rr = new Random(System.currentTimeMillis());
		for (int i=1; i<5; i++) {
			// 중복을 제거하고 번호 추가
			while (lotto.size()<=5) {
				lotto.add(rr.nextInt(45)+1);
			}
			System.out.println(lotto.toString());
			// lotto를 클리어 해야 함(지워야 함!)
			lotto.clear();
		}
		
	}

}
