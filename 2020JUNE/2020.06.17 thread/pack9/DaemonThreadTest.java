package pack9;

public class DaemonThreadTest {
	static class SaveDaemon extends Thread {
		public SaveDaemon() {
			this.setDaemon(true);				//5~7행 setDaemon() 메서드를 통해 데몬스레드를 구성
		}
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000*5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("자동 저장함");
			}
		}
	}
	
	public static void main(String[]args) {
		Thread daemon = new SaveDaemon();
		daemon.start();
		
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("작업 중..."+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main over");
	}
}
