package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummodel1.*;
public class ModifyAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ModifyAction 호출");
		
		BoardTO dto = new BoardTO();
		dto.setSeq(request.getParameter( "seq" ));
		
		BoardDAO dao = new BoardDAO();
		dto = dao.boardModify(dto);
		
		request.setAttribute("to", dto);
	}

}
