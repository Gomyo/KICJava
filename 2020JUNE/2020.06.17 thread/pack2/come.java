package pack2;

public class come extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i=1; i<=10; i++) {
			System.out.println("come : "+i);
		}
	}
}
