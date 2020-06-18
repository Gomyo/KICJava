package pack8;

public class MinuteAlarmThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000*30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("깜짝");
		}
		System.out.println("시간이 되었습니다.");
	}
}
