package pack9;

public class YieldTest {
	static class YieldThread extends Thread {
		String symbol;
	
		public YieldThread(String symbol) {
			this.symbol = symbol;
		}
	
		public void run() {
			for(int i=0;i<60;i++) {
				if(1%2==0) {
					System.out.print(symbol);
				} else {
					Thread.yield();
				}
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		
		
			new YieldThread("_").start();
			new YieldThread("^").start();
		
		}
	}
}//yield()