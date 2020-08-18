package model3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import albummodel1.BoardDAO;
import albummodel1.BoardListTO;
import albummodel1.BoardTO;

public class ListAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ListAction 호출");

		int cpage = 1;
		if( arg0.getParameter( "cpage" ) != null && !arg0.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( arg0.getParameter( "cpage" ) );
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
		
		arg0.setAttribute("lists", lists);
		arg0.setAttribute("listTO", listTO);
		arg0.setAttribute("cpage", cpage);
		arg0.setAttribute("recordPerPage", recordPerPage);
		arg0.setAttribute("totalRecord", totalRecord);
		arg0.setAttribute("totalPage", totalPage);
		arg0.setAttribute("blockPerPage", blockPerPage);
		arg0.setAttribute("startBlock", startBlock);
		arg0.setAttribute("endBlock", endBlock);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");
		modelAndView.addObject("list", arg0);
		
		return modelAndView;
	}

}
