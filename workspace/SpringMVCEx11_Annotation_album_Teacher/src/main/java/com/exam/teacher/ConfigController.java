package com.exam.teacher;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import albummodel1.BoardDAO;
import albummodel1.BoardListTO;
import albummodel1.BoardTO;
import albummodel1.CommentDAO;
import albummodel1.CommentTO;

@Controller
public class ConfigController {
	private String uploadPath = "C:/Coding/KICJava/workspace/SpringMVCEx11_Annotation_album_Teacher/src/main/webapp/upload";
	// Autowired를 쓰면 뒤에 new가 붙는다고 생각하면 된다. 자동 검색 기능
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/list.do")
	public String boardList(HttpServletRequest request, HttpServletResponse response, Model model) {

		System.out.println("ListAction 호출");

		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}
		BoardListTO listTO = new BoardListTO();
		listTO.setCpage( cpage );
		
		BoardDAO dao = new BoardDAO(dataSource);
		listTO = dao.boardList( listTO );
		
		model.addAttribute("listTO", listTO);
		
		return "board_list1";
	}
	
	@RequestMapping("/write.do")
	public String boardWrite(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("cpage", request.getParameter("cpage"));
		
		return "board_write1";
	}
	
	@RequestMapping("/write_ok.do")
	public String boardWriteOk(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		int maxFileSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		
		int flag = 1;
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
			
			BoardTO to = new BoardTO();
			
			to.setSubject( multi.getParameter( "subject" ) );
			to.setWriter( multi.getParameter( "writer" ) );
			to.setMail( "" );
			if( !multi.getParameter( "mail1" ).equals("") && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );	
			}
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			to.setFilename( multi.getFilesystemName( "upload" ) );
			to.setFilesize( multi.getFile( "upload" ).length() ); 
			to.setWip( request.getRemoteAddr() );
			
			BoardDAO dao = new BoardDAO(dataSource);
			flag = dao.boardWriteOk(to);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("flag", flag);
		return "board_write1_ok";
	}
	
	@RequestMapping("/view.do")
	public String boardView(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		System.out.println( "ViewAction 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO(dataSource);
		to = dao.boardView( to );
		
		CommentDAO cdao = new CommentDAO(dataSource);
		ArrayList<CommentTO> cLists = cdao.commentList( to );
		
		model.addAttribute("cpage", request.getParameter( "cpage" ) );
		model.addAttribute("to", to );
		model.addAttribute("cLists", cLists );
		
		return "board_view1";
	}
	
	@RequestMapping("/modify.do")
	public String boardModify(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println( "ModifyAction" );
		
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter( "seq" ));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		BoardDAO dao = new BoardDAO(dataSource);
//		to = dao.boardModify( to );
		
		try {
			conn = this.dataSource.getConnection();
			String sql = "select subject, writer, mail, content, filename from album_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString( "mail" ) );
				to.setContent( rs.getString( "content" ) );
				to.setFilename( rs.getString( "filename" ) );
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}

		model.addAttribute("cpage", request.getParameter("cpage"));
		model.addAttribute("to", to);
		
		return "board_modify1";
	}
	
	@RequestMapping("/modify_ok.do")
	public String boardModifyOk(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("modifyOk 호출");
		
		String uploadPath = "C:/Coding/KICJava/workspace/SpringMVCEx11_Annotation_album_Teacher/src/main/webapp/upload/";
		int maxFileSize = 1024 * 1024 * 10;
		String encType = "utf-8";
		
		BoardTO to = new BoardTO();
		
		try {
			MultipartRequest multi = new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy() );

			String cpage = multi.getParameter( "cpage" );
			String seq = multi.getParameter( "seq" );
			
			to = new BoardTO();
			to.setSeq( multi.getParameter( "seq" ) );
			to.setPassword( multi.getParameter( "password" ) );
			to.setSubject( multi.getParameter( "subject" ) );
			to.setMail( "" );
			if( !multi.getParameter( "mail1" ).equals("") && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );	
			}
			to.setContent( multi.getParameter( "content" ) );
			
			to.setFilename( "" );
			if( multi.getFile( "upload" ) != null ) {
				to.setFilename( multi.getFilesystemName( "upload" ) );
				to.setFilesize( multi.getFile( "upload" ).length() );
			}
			model.addAttribute("seq", seq);
			model.addAttribute("cpage", cpage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BoardDAO dao = new BoardDAO(dataSource);
		int flag = dao.boardModifyOk(to);
		
		model.addAttribute("flag", flag);
		
		return "board_modify1_ok";
	}
	
	@RequestMapping("/delete.do")
	public String boardDelete(HttpServletRequest request, HttpServletResponse response, Model model) {

		String cpage = request.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO(dataSource);
		to = dao.boardDelete( to );
		
		model.addAttribute("to", to);
		model.addAttribute("cpage", cpage);
		
		return "board_delete1";
	}
	
	@RequestMapping("/delete_ok.do")
	public String boardDeleteOk(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );	
		
		BoardDAO dao = new BoardDAO(dataSource);
		int flag = dao.boardDeleteOk(to);
		
		model.addAttribute("flag", flag);
		
		return "board_delete1_ok";
	}
	
	@RequestMapping("/comment_write_ok.do")
	public String commentWriteOk(HttpServletRequest request, HttpServletResponse response, Model model) {
	
		String cpage = request.getParameter( "cpage" );
		String pseq =  request.getParameter( "pseq" );
		
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );		
		cto.setWriter( request.getParameter( "writer" ) );
		cto.setPassword( request.getParameter( "password" ) );
		cto.setContent( request.getParameter( "content" ) );
		CommentDAO cdao = new CommentDAO(dataSource);
		int flag = cdao.commentWriteOk( cto );
		
		model.addAttribute("flag", flag);
		model.addAttribute("cpage", cpage);
		model.addAttribute("pseq", pseq);
		
		return "comment_write1_ok";
	
	}
}
