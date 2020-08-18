package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummodel1.*;

public class ListAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ListAction 호출");

		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}
		BoardListTO listTO = new BoardListTO();
		listTO.setCpage( cpage );
		
		BoardDAO dao = new BoardDAO();
		listTO = dao.boardList( listTO );
		
		int recordPerPage = listTO.getRecordPerPage();
		int totalRecord = listTO.getTotalRecord();
		int totalPage = listTO.getTotalPage();
		int blockPerPage = listTO.getBlockPerPage();
		
		int startBlock = listTO.getStartBlock();
		int endBlock = listTO.getEndBlock();
		
		ArrayList<BoardTO> lists = listTO.getBoardList();
		
		request.setAttribute("lists", lists);
		request.setAttribute("listTO", listTO);
		request.setAttribute("cpage", cpage);
		request.setAttribute("recordPerPage", recordPerPage);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("blockPerPage", blockPerPage);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
	}

}
