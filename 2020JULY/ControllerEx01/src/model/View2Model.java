package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View2Model {
	public void execute(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String data2 = request.getParameter("data2");
		
		System.out.println("View2Model 호출"+data2);
		
		request.setAttribute("data2", data2);
	}
}
