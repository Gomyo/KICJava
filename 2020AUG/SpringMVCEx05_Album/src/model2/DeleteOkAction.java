package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummodel1.*;

public class DeleteOkAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("DeleteOkAction 호출");
		
		BoardTO dto = new BoardTO();
		BoardDAO dao = new BoardDAO();
		
		String seq = request.getParameter("seq");
		String password = request.getParameter("password");
		String cpage = request.getParameter("cpage");
		
		dto.setSeq(seq);
		dto.setPassword(password);
		int flag = dao.boardDeleteOk(dto);
		
		request.setAttribute("flag", flag);
		request.setAttribute("seq", seq);
		request.setAttribute("cpage", cpage);
	}

}
