package pack2;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go g = new go();
		come c = new come();
		
		
		// 이렇게 실행하면 thread가 아니라 순차처리임
		//g.run();
		//c.run();
		
		// thread 시작(등록),		/ 순차적으로 안나옴 순차적으로 처리하려면 순차처리하는게 나음
		g.start();
		c.start();
	}

}

//방법1
