package spring;

public class ListAction implements BoardAction {
	private String writer;
	
	public ListAction() {
		// TODO Auto-generated constructor stub
		System.out.println("ListAction 호출");
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("writer : " + this.writer);
	}
	
	// custom method 추가 ( for initialize Bean instance)
	public void initializer() {
		System.out.println("초기화 메서드");
	}
	
	public void destroyer() {
		System.out.println("제거 메서드");
	}
}
