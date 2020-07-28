package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx02 extends HttpServlet {
	private String user;
	private String password;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("ServletEx02 init(ServletConfig)");
		
		this.user = config.getInitParameter("user");
		this.password = config.getInitParameter("password");
		
		System.out.println(this.user);
		System.out.println(this.password);
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 호출");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service(HttpServletRequest req, HttpServletResponse resp) 호출");
		System.out.println(this.user);
		System.out.println(this.password);
	}
}
