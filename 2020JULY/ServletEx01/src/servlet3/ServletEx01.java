package servlet3;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet {
	// doGet, doPost에서는 그냥 호출하는 것 뿐
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(req, resp);
	}
	// get과 post 상관없이 처리할 수 있는 구문을 만들어 주기
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
			try {
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
			
//				super.doPost(req, resp);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
}
