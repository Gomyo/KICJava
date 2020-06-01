
public class wrapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// static
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		Integer i1 = new Integer(10);
		Integer i2 = new Integer("10");
		System.out.println(i1);
		System.out.println(i2);
		
		byte b = i1.byteValue();
		double d = i1.doubleValue();
		System.out.println(b);
		System.out.println(d);
			
		// 진법 - 문자열 / static
		System.out.println(Integer.toBinaryString(10));
		
		// 문자열 -> 정수 / 
		// 문자열 -> 실수(*) : Float.parsefloat()
		int i = Integer.parseInt("10");
		int j = Integer.parseInt("20");
		System.out.println(i+j);
	}

}
