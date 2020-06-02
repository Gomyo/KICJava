import java.util.Arrays;

public class arrMain01 {

	public static void main(String[] args) {
		String[] arrs = {"aaa","bbb","ccc"};
		for (String arr : arrs) {
			System.out.println(arr);
		}
		
		
		//Arrays.fill(arrs,"xxx");
		//Arrays.fill(arrs,0,2,"xxx");
		
		for (String arr : arrs) {
			System.out.println(arr);
		}
		
		String[] arrs2 = {"aaa","dbbb","ccc"};
		
		// 내용값 비교
		if (Arrays.equals(arrs, arrs2)) {
			System.out.println("EQUAL");
		}
		else {
			System.out.println("DIFF");
		}
		
		Integer[] nums = {1,3,4,5,2};
		
		for (int n : nums) {
			System.out.println(n+"\t");
		}
		System.out.println("\n");
		
		Arrays.sort(nums);
		
		for (int n : nums) {
			System.out.println(n+"\t");
		}
		// 배열의 데이터를 쉽게 표시하는 방법
		
		
	}

}
