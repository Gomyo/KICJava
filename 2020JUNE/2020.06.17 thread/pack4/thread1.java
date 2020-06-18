package pack4;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 익명 이너클래스 / 1회성 쓰레드
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=1; i<=10; i++) {
					System.out.println("go : "+i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=1; i<=10; i++) {
					System.out.println("come : "+i);
				}
			}
		});
		
		t1.start();
		t2.start();
	}
	
	
}


