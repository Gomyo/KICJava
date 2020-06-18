package pack1;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go g = new go();
		come c = new come();
		
		g.run();			// g가 먼저 실행 	순차처리 
		c.run();
	}

}
