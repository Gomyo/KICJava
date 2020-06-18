package pack8;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinuteAlarmThread timeChecker = new MinuteAlarmThread();
		timeChecker.start();
		
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		timeChecker.interrupt();
	}  

}
