
public class SysMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		
		if(args.length != 1) {
			System.out.println("You have to enter only 1 char");
			System.out.println(args.length);
			// 강제종료
			System.exit(0);
		}
		System.out.println("Running...");
		System.out.println("end");
	}

}
