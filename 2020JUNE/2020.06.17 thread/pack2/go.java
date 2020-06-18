package pack2;
//이안에 run이라는 클래스가있음
public class go extends Thread {
		
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i=1; i<=10; i++) {
			System.out.println("go : "+i);
		}
		
	}
}
