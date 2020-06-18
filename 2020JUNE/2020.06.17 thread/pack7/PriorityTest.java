package pack7;

public class PriorityTest {
	static class MessengerThread extends Thread {
		public MessengerThread(String name) {
			super(name);
		}	
		
		public void run() {
			for(int i=0;i<30;i++) {
				System.out.print(this.getName());
			}
		}
	}
	public static void main(String[] args) {
		Thread fThread = new MessengerThread("F");
		Thread tThread = new MessengerThread("T");
		fThread.setPriority(Thread.MIN_PRIORITY);
		tThread.setPriority(Thread.MAX_PRIORITY);
		fThread.start();
		tThread.start();
	}
	
}
//553p  우선순위예제