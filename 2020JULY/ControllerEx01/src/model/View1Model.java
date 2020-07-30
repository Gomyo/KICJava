package model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View1Model {
	public void execute(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String data1 = request.getParameter("data1");
		System.out.println("View1Model 호출"+data1);
		
		// Model에서 jsp로 자녀를 넘기는 방법
		request.setAttribute("data1", data1);
	}
}
