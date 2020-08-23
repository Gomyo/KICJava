package spring;

public class WriteAction implements BoardAction {
	
	private String writer;
	
	public void setwriter(String writer) {
		this.writer = writer;
	}

	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Hello : " + writer);
		
		int sum = 0;
		for (int i=1; i<1000000; i++) {
			sum += i;
		}
		
	}	
	public void execute1() {
		
		System.out.println("execute 1 종료" + writer);
	}
	
	public void execute2() {
		
		System.out.println("execute 2 종료" + writer);
	}	

}
