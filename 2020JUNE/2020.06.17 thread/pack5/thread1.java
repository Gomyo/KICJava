package pack5;
// 결국 쓰레드는 = 메서드
public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gugudan g1 = new gugudan(3);
		gugudan g2 = new gugudan(4);
		gugudan g3 = new gugudan(5);
		
		// 쓰에드의 이름값을 주기	/ 이름이 없으면 자동으로 0 1 2 순으로 이름지음 g3 = thread -2 가나옴
		g1.setName("쓰레드1");
		g2.setName("쓰레드2");
		
		
		
		System.out.println("프로그램 시작");
		g1.start();
		g2.start();
		g3.start();
		System.out.println("프로그램 끝");
		
		
	}

}
