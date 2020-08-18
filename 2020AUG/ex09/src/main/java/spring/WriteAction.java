package spring;

public class WriteAction {
	private BoardTO boardTO;

	public BoardTO getBoardTO() {
		return boardTO;
	}

	public void setBoardTO(BoardTO boardTO) {
		this.boardTO = boardTO;
	}
	
	public void execute() {
		System.out.println(boardTO.getSeq());
		System.out.println(boardTO.getSubject());
	}
}
