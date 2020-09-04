package P1920;

import java.io.FileInputStream;
import java.util.*;

public class Main {
	static int[] A;
	
	static int bs(int left, int right, int B) {
		int mid = (left + right)/2;
		
		if (mid >= right) {
			return 0; // 다 탐색했는데 없는 경우
		}
		if (A[mid] == B) {
			return 1; // 탐색했고, 있음
		} else if (A[mid] < B) {
			return bs(mid+1, right, B); // 중간값 기준 왼쪽보다 크면, 오른쪽 탐색
		} else {
			return bs(left, mid, B); // 위와 반대
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\P1920\\input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int B;
		
		Arrays.sort(A);
		
		for (int i=0; i<M; i++) {
			B = sc.nextInt();
			System.out.println(bs(0, A.length, B));
		}
	}
}
