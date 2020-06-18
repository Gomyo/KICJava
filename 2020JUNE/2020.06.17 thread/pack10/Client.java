package pack10;

public class Client implements Runnable {
	private Account account;
	
	
	public Client(Account account) {
		this.account = account;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(account.getBalance()>0) {
			// 머니가 가질 수 있는 값을 모두 기술하면 100,200,300 만됨 이런게 시험문제 내기 좋다네?
			int money = (int)(Math.random()*3+1)*100;		// 100 200 300 을 랜덤으로 뽑는거
			account.withdraw(money);
			
			System.out.println("통장 잔고: "+account.getBalance());
		}
	}

}
