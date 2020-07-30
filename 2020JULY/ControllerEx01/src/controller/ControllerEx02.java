package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerEx02
 */
@WebServlet({ "*.do", "*.naver" })
public class ControllerEx02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getContextPath());
		try {
			request.setCharacterEncoding("utf-8");
			
			// 앞에 경로 부분은 삭제하고 파일명만 따악 남기기 ( /ControllerEx01 제거 )
			String path = request.getRequestURI().replaceAll(request.getContextPath(), "");
			
			String url = "/WEB-INF/views/error.jsp";
			if (path.equals("/view1.do") || path.equals("/view1.naver")) {
				url = "/WEB-INF/views/view1.jsp";
			} else if (path.equals("/view2.do") || path.equals("/view2.naver")) {
				url = "/WEB-INF/views/view2.jsp";
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
