package pack5;

public class gugudan extends Thread {
	private int dan;
	
	public gugudan(int dan) {			//생성자
		this.dan = dan;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(this.getName()+"쓰레드 시작");
		for(int i=1; i<=9; i++) {
			System.out.printf("%s X %s = %s%n",dan,i,(dan*i));
		}
		System.out.println(this.getName()+"쓰레드 끝");
	}
}
