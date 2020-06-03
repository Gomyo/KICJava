
public class exepMain03 {

	public static void main(String[] args) {
		int[] arr = new int[4];
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		try {
			System.out.println(arr[24]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException()이 선언된다. catch로 들어올 때 JVM이 알아서 해줌
			System.out.println("배열 크기 에러");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("슈우우우우웅........");
	}

}
