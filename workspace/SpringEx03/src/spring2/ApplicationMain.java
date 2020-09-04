package spring2;

public class ApplicationMain {
	public static void main(String[] args) {
		
		BoardTO to = new BoardTO();
		writeAction action = new writeAction(to);
		
		action.execute();
	}
}
