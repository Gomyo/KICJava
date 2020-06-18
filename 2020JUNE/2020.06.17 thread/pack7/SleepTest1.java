package pack7;

import java.time.LocalTime;

public class SleepTest1 {
	static class Timer extends Thread {
		public void run() {
			for(int i=0;i<3;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("에러"+e.getMessage());
				}
				System.out.println("째깍: "+LocalTime.now());
			}
		}
	}
	
	public static void main(String[]args) {
		Timer timer = new Timer();
		timer.start();
	}
}
// 쉬었다가 작업을 해야할 경우 사용 / 555p / sleep() 메서드
