package guguservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet{
	StringBuffer guguResult = new StringBuffer();
	
	public StringBuffer getGuguResult() {
		return guguResult;
	}

	public void setGuguResult(StringBuffer guguResult) {
		this.guguResult = guguResult;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String st = req.getParameter("startDan");
		String ed = req.getParameter("endDan");
		int startDan = Integer.parseInt(st); 
		int endDan = Integer.parseInt(ed); 
		
		resp.setContentType("text/html;charset=utf-8");
		StringBuffer html = new StringBuffer();
		html.append("<!Doctype html>");
		html.append("<meta charset='utf-8'/>");
		html.append("<head>");
		html.append("<title>구구단</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<table border='1'>");
		for (int i = startDan; i<=endDan; i++ ) {
			html.append("<tr>");
			for (int j=1; j<=9; j++) {
				html.append("<td>"+String.format("%s X %s = %s", i,j,(i*j))+"</td>");
			}
			html.append("</tr>");
		}
		html.append("</table>");
		html.append("</body>");
		html.append("</html>");
		
		req.setAttribute("guguResult", html);
		req.getRequestDispatcher("./gugudanForm.jsp").forward(req, resp);
		
//		PrintWriter out = resp.getWriter();
		// out은 IO스트림이기 때문에 닫아준다. try catch는 throw로 위임되어 있음
//		out.println(html);
//		out.close();
		// jsp 한페이지에 표현하기 위해 값 보내기
		
	}
}
