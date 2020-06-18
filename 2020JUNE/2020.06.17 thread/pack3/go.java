package pack3;

public class go implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=1; i<=10; i++) {
			System.out.println("go : "+i);
		}
	}

}
