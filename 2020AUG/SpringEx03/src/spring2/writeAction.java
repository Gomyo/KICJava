package spring2;

public class writeAction {
	private BoardTO to;
	
	public writeAction() {
		System.out.println("Call WriteAction");
	}
	
	public writeAction(BoardTO to) {
		System.out.println("Call WriteAction(BoardTO to)");
		this.to = to;
	}
	
	public void execute() {
		System.out.println("Call execute()");
	}
}
