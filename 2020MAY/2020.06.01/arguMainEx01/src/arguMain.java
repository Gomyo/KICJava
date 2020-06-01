
public class arguMain {
	public void add(int... nums) {
//		System.out.println(nums.length);
		for (int num : nums) {
			System.out.println(num + "\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arguMain am = new arguMain();
		am.add();
		am.add(1,2,3);
		am.add(1,2,3,34,5,63);
	}
}
