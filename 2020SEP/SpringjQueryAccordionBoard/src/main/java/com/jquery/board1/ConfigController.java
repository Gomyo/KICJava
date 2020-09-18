package com.jquery.board1;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model1.*;


@Controller
public class ConfigController {
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value="/index.do")
	public ModelAndView indexRequest() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_ui");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/board_json.do")
	public ModelAndView boardRequest(HttpServletRequest request, HttpServletResponse arg1) {
		
		System.out.println("Call Board List");
		
		BoardListTO listTO = new BoardListTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM JQUERY_BOARD";
			pstmt = conn.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			
			rs = pstmt.executeQuery();
			
			ArrayList<BoardTO> boardLists = new ArrayList<BoardTO>();
			
			while (rs.next()) {
				BoardTO to = new BoardTO();
				to.setSeq( rs.getString("seq" ) );
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString( "mail" ) );
				to.setPassword( rs.getString( "password" ) );
				to.setContent( rs.getString( "content") );
				boardLists.add( to );
			}
			listTO.setBoardList(boardLists);
			
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		ArrayList<BoardTO> boardLists = listTO.getBoardList();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_json");
		modelAndView.addObject("boardLists", boardLists);
		return modelAndView;
	}
	
	@RequestMapping(value="/board_write.do")
	public ModelAndView writeRequest(HttpServletRequest request) {
		System.out.println("Write new content");
		/* 이렇게 하면 인스턴스를 하나 만드는 데에 메모리가 쓰일 듯
		BoardTO to = new BoardTO();
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		to.setEmail(request.getParameter("email"));
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));
		*/
		String subject = request.getParameter("subject");
	 	String writer = request.getParameter("writer");
	 	String mail = request.getParameter("mail");
	 	String password = request.getParameter("password");
	 	String content = request.getParameter("content");
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		int flag = 1;
		
		try{
			conn = this.dataSource.getConnection();
			
			String sql = "insert into jquery_board values( 0, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, subject);
			pstmt.setString(3, mail);
			pstmt.setString(4, password);
			pstmt.setString(5, content);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				flag = 0;
			}
			
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}
		
		request.setAttribute("flag", flag);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_crud");
		modelAndView.addObject("lists", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/board_delete.do")
	public ModelAndView deleteRequest(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String seq = request.getParameter("seq");
	 	String password = request.getParameter("password");
	 	
		int flag = 1;
		try{
			conn = this.dataSource.getConnection();
			String sql = "delete from jquery_board where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.setString(2, password);
				
			if(pstmt.executeUpdate() == 1) {
				flag = 0;
			}
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}

		request.setAttribute("flag", flag);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_crud");
		modelAndView.addObject("list", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/board_modify.do")
	public ModelAndView boardModifyRequest(HttpServletRequest request) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String seq = request.getParameter("seq");
		String subject = request.getParameter("subject");
	 	String mail = request.getParameter("mail");
	 	String password = request.getParameter("password");
	 	String content = request.getParameter("content");
	 	
		int flag = 1;
		try{
			conn = this.dataSource.getConnection();
			String sql = "update jquery_board set subject=?, mail=?, content=? where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, seq);
			pstmt.setString(5, password);
				
			if(pstmt.executeUpdate() == 1) {
				flag = 0;
			}
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( rs != null ) try{ rs.close(); } catch(SQLException e) {}
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}

		request.setAttribute("flag", flag);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_crud");
		modelAndView.addObject("list", request);
		
		return modelAndView;
	}
	
}
		
