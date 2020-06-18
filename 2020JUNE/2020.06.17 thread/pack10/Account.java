package pack10;

public class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	// 인출
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			balance -= money;  //잔고를 뺴줌
		} else {
			System.out.println("잔고가 없습니다.");
		}
	}
}
//synchronized 메서드 또는 블록에 사용할 수 있음