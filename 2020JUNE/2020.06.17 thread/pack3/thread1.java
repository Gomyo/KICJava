package pack3;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		go g = new go();
		come c = new come();
		
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(c);				// 이렇게 해야 스타트 메서드가나옴
		*/
		
		Thread t1 = new Thread(new go());
		Thread t2 = new Thread(new come());		// 위에랑 같음
		
		t1.start();
		t2.start(); 		// 순차처리안됨 순차처리 되는거는 너무빨라서그럼 
	}

}
