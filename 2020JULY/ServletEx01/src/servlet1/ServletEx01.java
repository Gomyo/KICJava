package servlet1;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get / post
		resp.setContentType("text/html;charshet=utf-8");
		
		StringBuffer html = new StringBuffer();
		html.append("<!Doctype html>");
		html.append("<head>");
		html.append("<meta charset='utf-8'>");
		html.append("<title>ServletEx01</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("Hello Servlet");
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter out = resp.getWriter();
		// out은 IO스트림이기 때문에 닫아준다. try catch는 throw로 위임되어 있음
		out.println(html);
		out.close();
		
	}
}
