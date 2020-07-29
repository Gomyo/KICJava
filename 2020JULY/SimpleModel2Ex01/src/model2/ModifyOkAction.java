package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.BoardDAO;
import model1.BoardTO;

public class ModifyOkAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ModifyOkAction 호출");
		

		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify(to);
		
		to.setSeq(request.getParameter("seq"));
		to.setPassword(request.getParameter("password"));
		to.setSubject(request.getParameter("subject"));
		if(!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		} else {
			to.setMail("");
		}
		to.setContent(request.getParameter("content"));
		
		int flag = dao.boardModifyOK(to);
		String seq = to.getSeq();
		
		request.setAttribute("flag", flag);
		request.setAttribute("seq", seq);
	}

}
