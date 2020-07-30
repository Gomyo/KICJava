package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.CommentAction;
import model2.CommentWriteOkAction;
import model2.ListAction;



/**
 * Servlet implementation class CommentControllerEx01
 */
@WebServlet("/comment/*")
public class CommentControllerEx01 extends HttpServlet {
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
			String path = request.getRequestURI().replaceAll(request.getContextPath() + "/comment", "");
			
			String url = "/WEB-INF/design_album1/error.jsp";
			
			CommentAction commentAction = null;
			
			if (path.equals("/comment_write_ok.do")) {
				commentAction = new CommentWriteOkAction();
				commentAction.execute(request, response);
				url = "/WEB-INF/design_album1/board_comment1_ok.jsp";
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
