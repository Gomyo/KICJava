package pack7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinTest {
	static class GuguThread extends Thread {
		private int dan;
		String[] result = new String[9];
		
		public GuguThread(int dan) {
			this.dan = dan;
		}
		
		public void run() {
			for(int i=1; i<10;i++) {
				result[i-1] = dan +"*" +i+"="+(dan*i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}														// 16~27행 1초씩 쉬면서 result에 구구단을 저장. 전체를 완성하는데 9초 정도걸림
			}
			System.out.print(dan +"단완료\t");			// 구구단을 저장하는 작업이 끝나면 완료메세지
		}
	}
	
	public static void main(String[]args) {
		List<GuguThread> gugus = new ArrayList<>();		// 구구단을 관리할 리스트를 선언
		
		for(int i=1;i<10;i++) {						//33~37행 9개의 guguThread를 만들어서 리스트에 담고 start()를 호출해 runable상태로 만듬
			GuguThread gugu = new GuguThread(i);
			gugus.add(gugu);
			gugu.start();
		}
		
		for(GuguThread gugu: gugus) {
			try {
				gugu.join();	//메인쓰러드 작업에 gugu를 끼워준다		/ 39~46행 GuguThread 객체의 join()을 호출함으로써 다른 쓰레드가 종료될 떄까지 메인 스레드는 대기상태로 존재
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n구구단 출력");							//47~50행 모든 쓰레드가 종료 후 메인쓰레드가 다시 runable > 동작으로 상태를 변경하면서 구구단 출력
		for(GuguThread gugu: gugus) {
			System.out.println(Arrays.toString(gugu.result));
		}
	}
}//join()
