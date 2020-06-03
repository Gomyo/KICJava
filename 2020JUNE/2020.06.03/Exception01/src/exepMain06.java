
public class exepMain06 {

	public static void main(String[] args) {
		// 강제 Exception 발생
		try {
			if (args.length == 1) {
				System.out.println(args[0]);
			} else {
	//			System.out.println("Wrong Input");
				throw new Exception("Wrong Input");
			}
		} catch (Exception e) {
			System.out.println("Exception Occurred"); //
			System.out.println(e.getMessage()); // Reason
		}
	}

}
