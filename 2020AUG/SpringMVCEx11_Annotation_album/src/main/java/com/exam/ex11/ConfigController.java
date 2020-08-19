package com.exam.ex11;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

import albummodel1.BoardDAO;
import albummodel1.BoardListTO;
import albummodel1.BoardTO;
import albummodel1.CommentDAO;
import albummodel1.CommentTO;

@Controller
public class ConfigController {
	@Autowired
	private DataSource dataSource;
	private String uploadPath = "C:/Coding/KICJava/2020AUG/SpringMVCEx11_Annotation_album/src/main/webapp/upload";
	
	@RequestMapping(value="/list.do")
	public ModelAndView listRequest(HttpServletRequest request, HttpServletResponse arg1) {

		System.out.println("ListAction 호출");
		
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}
		BoardListTO listTO = new BoardListTO();
		
		// DAO 삭제
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int recordPerPage = listTO.getRecordPerPage();
		int blockPerPage = listTO.getBlockPerPage();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select seq, subject, writer, cmt, filename, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from album_board1 order by seq desc";
			pstmt = conn.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			
			rs = pstmt.executeQuery();
			
			rs.last();
			listTO.setTotalRecord( rs.getRow() );
			rs.beforeFirst();
			
			listTO.setTotalPage( ( ( listTO.getTotalRecord() - 1 ) / recordPerPage ) + 1 );

			int skip = ( cpage - 1 ) * recordPerPage;
			if( skip != 0 ) rs.absolute( skip );
			
			ArrayList<BoardTO> boardLists = new ArrayList<>();
			for( int i=0 ; i<recordPerPage && rs.next() ; i++ ) {
				BoardTO to = new BoardTO();
				to.setSeq( rs.getString("seq" ) );
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setWdate( rs.getString( "wdate" ) );
				to.setHit( rs.getString( "hit" ) );
				to.setWgap( rs.getInt( "wgap") );
				to.setFilename( rs.getString( "filename" ) == null ? "" : rs.getString( "filename" ) );
				to.setCmt( rs.getString( "cmt" ) );
				boardLists.add( to );
			}
			
			listTO.setBoardList( boardLists );
			
			listTO.setStartBlock( ( ( cpage - 1) / blockPerPage ) * blockPerPage + 1 );
			listTO.setEndBlock( ( ( cpage - 1) / blockPerPage ) * blockPerPage + blockPerPage );
			if( listTO.getEndBlock() >= listTO.getTotalPage() ) {
				listTO.setEndBlock(listTO.getTotalPage() );
			}
			
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		recordPerPage = listTO.getRecordPerPage();
		int totalRecord = listTO.getTotalRecord();
		int totalPage = listTO.getTotalPage();
		blockPerPage = listTO.getBlockPerPage();
		
		int startBlock = listTO.getStartBlock();
		int endBlock = listTO.getEndBlock();
		
		ArrayList<BoardTO> lists = listTO.getBoardList();
		
		request.setAttribute("lists", lists);
		request.setAttribute("listTO", listTO);
		request.setAttribute("cpage", cpage);
		request.setAttribute("recordPerPage", recordPerPage);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("blockPerPage", blockPerPage);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");
		modelAndView.addObject("list", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/write.do")
	public ModelAndView writeRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("WriteAction 호출");
			
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/write_ok.do")
	public ModelAndView writeOkRequest(HttpServletRequest request, HttpServletResponse response) {
		
		int maxFileSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		
		BoardTO to = new BoardTO();
		
		try {
			int flag = 1;
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
			
			to.setSubject(multi.getParameter("subject"));
			to.setWriter(multi.getParameter("writer"));
			to.setMail("");
			if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")) {
				to.setMail(multi.getParameter("mail1") + "@" + multi.getParameter("mail2"));
			}
			to.setPassword(multi.getParameter("password"));
			to.setContent(multi.getParameter("content"));
			to.setWip(request.getRemoteAddr());
			
			String filename = multi.getFilesystemName("upload");
			to.setFilename(filename);
			
			long filesize = 0;
			File file = multi.getFile("upload");
			// 파일 업로드 된 것이 있을 때 길이 리턴. if처리를 안하면 NPE
			if (file != null) {
				filesize = file.length();
			}
			to.setFilesize(filesize);
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = this.dataSource.getConnection();
				
				String sql = "insert into album_board1 values (0, ?, ?, ?, ?, ?, ?, ?, 0, 0, ?, now())";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, to.getSubject() );
				pstmt.setString( 2, to.getWriter() );
				pstmt.setString( 3, to.getMail() );
				pstmt.setString( 4, to.getPassword() );
				pstmt.setString( 5, to.getContent() );
				pstmt.setString( 6, to.getFilename() );
				pstmt.setLong( 7, to.getFilesize() );
				pstmt.setString( 8, to.getWip() );
				
				int result = pstmt.executeUpdate();
				if( result == 1 ) {
					flag = 0;
				}
			} catch( SQLException e ) {
				System.out.println( "[에러] : " + e.getMessage() );
			} finally {
				if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
				if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
			}
			
			request.setAttribute("flag", flag);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1_ok");
		modelAndView.addObject("write_ok", request);
		
		return modelAndView;
	}

	@RequestMapping(value="/view.do")
	public ModelAndView viewRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("ViewAction 호출");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String cpage = request.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		CommentTO cto = new CommentTO();
		cto.setPseq(request.getParameter("pseq"));
		
		try {
			conn = this.dataSource.getConnection();

			String sql = "update album_board1 set hit=hit+1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			pstmt.executeUpdate();
			
			pstmt.close();
			
			sql = "select subject, writer, mail, wip, wdate, hit, content, filename from album_board1 where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString( "mail" ) );
				to.setWip( rs.getString( "wip" ) );
				to.setWdate( rs.getString( "wdate" ) );
				to.setHit( rs.getString( "hit" ) );
				to.setContent( rs.getString( "content" ).replaceAll( "\n", "<br />" ) );
				to.setFilename( rs.getString( "filename" ) );
			}
		} catch( SQLException e ) {
			System.out.println("[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		ArrayList<CommentTO> commentLists = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select seq, writer, content, wdate from album_comment1 where pseq=? order by seq";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			
			rs = pstmt.executeQuery();

			while( rs.next() ) {
				cto = new CommentTO();
				cto.setSeq( rs.getString("seq" ) );
				cto.setWriter( rs.getString( "writer" ) );
				cto.setContent( rs.getString( "content" ) );
				cto.setWdate( rs.getString("wdate"));
				commentLists.add( cto );
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null) try { conn.close(); } catch( SQLException e ) {}
		}
		
		String seq = to.getSeq();
		String subject = to.getSubject();
		String writer = to.getWriter();
		String mail = to.getMail();
		String wip = to.getWip();
		String wdate = to.getWdate();
		String hit = to.getHit();
		String content = to.getContent();
		String filename = to.getFilename();
		
		
		request.setAttribute("cpage", cpage);
		request.setAttribute("seq", seq);
		request.setAttribute("subject", subject);
		request.setAttribute("writer", writer);
		request.setAttribute("mail", mail);
		request.setAttribute("wdate", wdate);
		request.setAttribute("hit", hit);
		request.setAttribute("content", content);
		request.setAttribute("filename", filename);
		request.setAttribute("commentLists", commentLists);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");
		modelAndView.addObject("view", request);
		
		return modelAndView;
	}

	@RequestMapping(value="modify.do")	
	public ModelAndView modifyRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ModifyAction 호출");
		
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter( "seq" ));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
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
		
		request.setAttribute("to", to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1");
		modelAndView.addObject("modify", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value="modify_ok.do")
	public ModelAndView modifyOkRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("modifyOk 호출");
		
		try {
			int maxFileSize = 1024 * 1024 * 5;
			String encType = "utf-8";
			
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());

			// get
			String seq = multi.getParameter("seq");
			String cpage = multi.getParameter("cpage");
			String password = multi.getParameter("password");
			String subject = multi.getParameter("subject");
			String mail = "";
			if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")){
				mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");	
			}
			String content = multi.getParameter("content");
			String filename = multi.getParameter("filename");
			String newfilename = multi.getFilesystemName("upload");
			long newfilesize = 0; 
			File newfile = multi.getFile("upload");
			if (newfile != null) {
				newfilesize = newfile.length();
			}
			
			BoardTO to = new BoardTO();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int flag = 2;
			
			try {
				to.setSeq(seq);
				to.setSubject(subject);
				to.setMail(mail);
				to.setPassword(password);
				to.setContent(content);
				to.setFilename(newfilename);
				
				conn = this.dataSource.getConnection();
				
				String sql = "select filename from album_board1 where seq=?";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, to.getSeq() );
				
				rs = pstmt.executeQuery();
				String deleteFileName = null;
				if( rs.next() ) {
					deleteFileName = rs.getString( "filename" );
				}
				pstmt.close();
				
				if( to.getFilename() != null ) {
					sql = "update album_board1 set subject=?, mail=?, content=?, filename=?, filesize=? where seq=? and password=?";
					pstmt = conn.prepareStatement( sql );
					pstmt.setString( 1, to.getSubject() );
					pstmt.setString( 2, to.getMail() );
					pstmt.setString( 3, to.getContent() );
					pstmt.setString( 4, to.getFilename() );
					pstmt.setLong( 5, to.getFilesize() );
					pstmt.setString( 6, to.getSeq() );
					pstmt.setString( 7, to.getPassword() );				
				} else {
					sql = "update album_board1 set subject=?, mail=?, content=? where seq=? and password=?";
					pstmt = conn.prepareStatement( sql );
					pstmt.setString( 1, to.getSubject() );
					pstmt.setString( 2, to.getMail() );
					pstmt.setString( 3, to.getContent() );
					pstmt.setString( 4, to.getSeq() );
					pstmt.setString( 5, to.getPassword() );
				}
				
				int result = pstmt.executeUpdate();
				System.out.println(result);
				if( result == 0 ) {
					flag = 1;		
					
				} else if( result == 1 ) {
					flag = 0;
					
					if( to.getFilename() != null ) {
						File file = new File( uploadPath, deleteFileName );
						file.delete();
					}
				}
			} catch( SQLException e ) {
				System.out.println( "[에러] : " + e.getMessage() );
			} finally {
				if( rs != null) try { rs.close(); } catch( SQLException e ) {}
				if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
				if( conn != null) try { conn.close(); } catch( SQLException e ) {}
			}
			
			request.setAttribute("flag", flag);
			request.setAttribute("seq", seq);
			request.setAttribute("cpage", cpage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1_ok");
		modelAndView.addObject("modify_ok", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value="delete.do")	
	public ModelAndView deleteRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteAction 호출");
		
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();

			String sql = "select subject, writer from album_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		request.setAttribute("to", to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1");
		modelAndView.addObject("delete", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value="delete_ok.do")	
	public ModelAndView deleteOkRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteOkAction 호출");
		
		BoardTO to = new BoardTO();
		
		String seq = request.getParameter("seq");
		String password = request.getParameter("password");
		String cpage = request.getParameter("cpage");
		
		to.setSeq(seq);
		to.setPassword(password);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int flag = 2;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select filename from album_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			
			rs = pstmt.executeQuery();

			String deleteFileName = null;
			if( rs.next() ) {
				deleteFileName = rs.getString( "filename" );
			}
			
			pstmt.close();
			
			sql = "delete from album_board1 where seq=? and password=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			pstmt.setString( 2, to.getPassword() );
			
			int result = pstmt.executeUpdate();
			if(result == 0) {
				flag = 1;
			} else if( result == 1 ) {
				flag = 0;
				
				File file = new File( uploadPath, deleteFileName );
				file.delete();

				sql = "delete from album_comment1 where pseq=?";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, to.getSeq() );
				pstmt.executeUpdate();
			}
		} catch( SQLException e ) {
			System.out.println("[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		request.setAttribute("flag", flag);
		request.setAttribute("seq", seq);
		request.setAttribute("cpage", cpage);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1_ok");
		modelAndView.addObject("delete_ok", request);
		
		return modelAndView;
	}
	
	@RequestMapping(value="comment_write_ok.do")	
	public ModelAndView commentOkRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "CommentWriteOkAction" );
		
		String cpage = request.getParameter( "cpage" );
		String pseq =  request.getParameter( "pseq" );
		
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );		
		cto.setWriter( request.getParameter( "cwriter" ) );
		cto.setPassword( request.getParameter( "cpassword" ) );
		cto.setContent( request.getParameter( "ccontent" ) );
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "insert into album_comment1 values (0, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, cto.getPseq() );
			pstmt.setString( 2, cto.getWriter() );
			pstmt.setString( 3, cto.getPassword() );
			pstmt.setString( 4, cto.getContent() );
			
			int result = pstmt.executeUpdate();
			if( result == 1 ) {
				sql = "update album_board1 set cmt=cmt+1 where seq=?";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, cto.getPseq() );
				
				pstmt.executeUpdate();

				flag = 0;
			}		
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( pstmt != null) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null) try { conn.close(); } catch( SQLException e ) {}
		}
		
		request.setAttribute("flag", flag);
		request.setAttribute("cpage", cpage);
		request.setAttribute("pseq", pseq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_comment1_ok");
		modelAndView.addObject("comment_ok", request);
		
		return modelAndView;
	}
}
		
