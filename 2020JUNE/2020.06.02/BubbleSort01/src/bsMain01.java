import java.util.Arrays;
import java.util.Random;

public class bsMain01 {

	public static void main(String[] args) {
		// 그냥 책을 보고 따라 쳐 보라고 하시는데... 개인 공부가 필요한 것은 알겠지만 너무 수강생들한테 떠넘기는 느낌이 났다.
		// 나처럼 미리 해 본 사람이 아니라면 이 수업 시간에 뭔가를 얻어가긴 힘들다. 나조차도 복습이기에 좋지, 새로 얻는 것은 없다.
			Random r = new Random();
			int tmp = 0;
			int[] arr = new int[10];
			
			for (int i=0; i<10; i++) {
				arr[i] = r.nextInt(100);
			}
			System.out.println("Initial Status");
			
//			for (int i : arr) {
//				System.out.printf("%d\t", i);
//			}
			System.out.println(Arrays.toString(arr));
			System.out.println("----------------------------------");
			// Sort
			for (int i=0; i<arr.length-1; i++) {
				for (int j=0; j<arr.length-1; j++) {
					if (arr[j] > arr[j+1]) {
						tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
			System.out.println("\nAfter Sorted");
//			for (int i : arr) {
//				System.out.printf("%d\t", i);
//			}
			System.out.println(Arrays.toString(arr));
			System.out.println("----------------------------------");
			// arraycopy() 메서드 사용해 보기
			// arraycopy(from, fromidx, to, toidx, length(얼마나))
			int[] result = new int[10];
			System.arraycopy(arr, 0, result, 0, arr.length);
			System.out.println(Arrays.toString(result));
	}

}
