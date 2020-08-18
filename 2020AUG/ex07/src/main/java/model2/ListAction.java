package model2;

import model1.BoardDAO;

public class ListAction implements BoardAction {
	private BoardDAO dao;
	
	public ListAction(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	public void execute() {
		dao.boardList();
	}
}
