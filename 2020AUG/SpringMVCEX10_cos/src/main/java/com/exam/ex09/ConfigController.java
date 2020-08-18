package com.exam.ex09;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class ConfigController {
	
	@RequestMapping(value="/write.do")
	public ModelAndView handleRequest21( HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/write_ok.do")
	public ModelAndView handleRequest22( HttpServletRequest request, HttpServletResponse response) {
		
		String uploadPath = "C:/Coding/KICJava/workspace/SpringMVCEX10_cos/src/main/webapp/upload";
		int maxFileSize = 1024 * 1024 * 2;
		String encType = "utf-8";
		
		try {
			MultipartRequest multi 
				= new MultipartRequest(request
						, uploadPath
						, maxFileSize
						, encType
						, new DefaultFileRenamePolicy());
			System.out.println("업로드 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write_ok");
		
		return modelAndView;
	}
	
}
