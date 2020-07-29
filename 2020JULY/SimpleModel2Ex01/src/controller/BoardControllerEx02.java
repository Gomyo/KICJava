package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.*;

/**
 * Servlet implementation class BoardControllerEx02
 */
@WebServlet("*.do")
public class BoardControllerEx02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			
			// 앞에 경로 부분은 삭제하고 파일명만 따악 남기기 ( /ControllerEx01 제거 )
			String path = request.getRequestURI().replaceAll(request.getContextPath(), "");
			
			String url = "/WEB-INF/views/error.jsp";
			
			BoardAction boardAction = null;
			if (path.equals("/*.do") || path.equals("/list.do")) {
				boardAction = new ListAction();
				boardAction.execute(request, response);
				url = "/WEB-INF/model3/board_list1.jsp";
			} 
			else if (path.equals("/view.do")) {
				boardAction = new ViewAction();
				boardAction.execute(request, response);
				url = "/WEB-INF/model3/board_view1.jsp";
			}
			else if (path.equals("/write.do")) {
				boardAction = new WriteAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/model3/board_write1.jsp";
			}
			else if (path.equals("/write_ok.do")) {
				boardAction = new WriteOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/model3/board_write1_ok.jsp";
			}
			else if (path.equals("/modify.do")) {
				boardAction = new ModifyAction();
				boardAction.execute(request, response);
				url = "/WEB-INF/model3/board_modify1.jsp";
			}
			else if (path.equals("/modify_ok.do")) {
				boardAction = new ModifyOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/model3/board_modify1_ok.jsp";
			}
			else if (path.equals("/delete.do")) {
				boardAction = new DeleteAction();
				boardAction.execute(request, response);
				url = "/WEB-INF/model3/board_delete1.jsp";
			}
			else if (path.equals("/delete_ok.do")) {
				boardAction = new DeleteOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/model3/board_delete1_ok.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
