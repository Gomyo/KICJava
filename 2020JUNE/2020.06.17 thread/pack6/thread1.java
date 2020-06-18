package pack6;

import pack5.gugudan;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new gugudan(2));
		Thread t2 = new Thread(new gugudan(4));
		
		t1.setName("쓰레드 1");
		t2.setName("쓰레드 2");
		
		t1.start();
		t2.start();
	}

}
