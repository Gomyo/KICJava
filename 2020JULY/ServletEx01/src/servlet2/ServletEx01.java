package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 입력 : request로 데이터를 갖고와서 처리할 수 있다. 입력 관련 부분을 처리해야 한다.
		req.setCharacterEncoding("utf-8");
		String data = req.getParameter("data");
				
		
		resp.setContentType("text/html;charset=utf-8");
		
		StringBuffer html = new StringBuffer();
		html.append("<!Doctype html>");
		html.append("<head>");
		html.append("<meta charset='utf-8'/>");
		html.append("<title>ServletEx01</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("Get 요청" + data);
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter out = resp.getWriter();
		// out은 IO스트림이기 때문에 닫아준다. try catch는 throw로 위임되어 있음
		out.println(html);
		out.close();
	}
	
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 입력 : request로 데이터를 갖고와서 처리할 수 있다. 입력 관련 부분을 처리해야 한다.
		req.setCharacterEncoding("utf-8");
		String data = req.getParameter("data");
		
		// 출력
		
		resp.setContentType("text/html;charset=utf-8");
		StringBuffer html = new StringBuffer();
		html.append("<!Doctype html>");
		html.append("<head>");
		html.append("<meta charset='utf-8'/>");
		html.append("<title>ServletEx01</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("Post 요청"+ data);
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter out = resp.getWriter();
		// out은 IO스트림이기 때문에 닫아준다. try catch는 throw로 위임되어 있음
		out.println(html);
		out.close();
	}
	
}
