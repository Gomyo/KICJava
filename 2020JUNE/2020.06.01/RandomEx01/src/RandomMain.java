import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		Random r1 = new Random();
		
		System.out.println(r1.nextDouble());
		System.out.println(r1.nextInt());
		System.out.println(r1.nextInt(10));
		
		// lotto cash~ 
		System.out.println(r1.nextInt(45)+1);
	}
	
}
