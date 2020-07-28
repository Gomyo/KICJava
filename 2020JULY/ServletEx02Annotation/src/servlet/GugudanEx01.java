package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanEx01
 */
@WebServlet(name = "gugudan", urlPatterns = { "/gugudan" })
public class GugudanEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			
			String startDan = request.getParameter("startDan");
			String endDan = request.getParameter("endDan");
			
			// 출력 형식 지정
			response.setContentType("text/html;charset=utf-8");
			
			StringBuffer html = new StringBuffer();
			html.append("<!doctype html>");
			html.append("<html>");
			html.append("<head>");
			html.append("</head>");
			html.append("<body>");
			html.append("<form action='./gugudan' method='post'>");
			html.append("시작단 <input type='text' name='startDan'/>");
			html.append("~");
			html.append("끝단 <input type='text' name='endDan'/>");
			html.append("&nbsp&nbsp");
			html.append("<input type='submit' value='구구단 출력'/>");
			html.append("</form>");
			html.append("<br><hr/><br>");
			if (startDan != null && endDan != null) {
				int startInt = Integer.parseInt(startDan);
				int endInt = Integer.parseInt(endDan);
				html.append("<table border='1' width='800'>");
				for (int i=startInt; i<=endInt; i++) {
					html.append("<tr>");
					for (int j=1; j<=9; j++) {
						html.append("<td>"+String.format("%d X %d = %d", i,j,i*j) + "</td>");
					}
					html.append("</tr>");
				}
				html.append("</table>");
			}
			
			html.append("</body>");
			html.append("</html>");
			
			PrintWriter out = response.getWriter();
			out.println(html);
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
