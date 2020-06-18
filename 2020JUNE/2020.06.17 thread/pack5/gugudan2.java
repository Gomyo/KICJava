package pack5;

public class gugudan2 implements Runnable {
	private int dan;
	
	public gugudan2(int dan) {			//생성자
		this.dan = dan;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
								// 쓰레드 이름만 가지고 오는 방법  Thread.currentThread().getName()
		System.out.println(Thread.currentThread().getName()+"쓰레드 시작");
		for(int i=1; i<=9; i++) {
			System.out.printf("%s X %s = %s%n",dan,i,(dan*i));
		}
		System.out.println(Thread.currentThread().getName()+"쓰레드 끝");
	}
}
// runable 사용
