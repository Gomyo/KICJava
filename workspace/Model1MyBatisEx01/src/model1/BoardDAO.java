package model1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BoardDAO {
	
	private SqlSession sqlSession;
	
	public BoardDAO() {
		String resource = "myBatisConfig.xml";
		
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			this.sqlSession = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) try {is.close();} catch (IOException e) {}
		}
	}
	
	public void boardWriter() {
		
	}
	
	public int boardWriterOK(BoardTO to) {
		
		int flag = 1;
		
		BoardTO wto = new BoardTO();
		wto.setSubject(to.getSubject());
		wto.setWriter(to.getWriter());
		wto.setMail(to.getMail());
		wto.setPassword(to.getPassword());
		wto.setContent(to.getContent());
		wto.setWip(to.getWip());
		
		int result = sqlSession.insert("write_ok",wto);
		
		if(result == 1) {
			flag = 0;
		}
		return flag;
	}
	
	public ArrayList<BoardTO> boardList() {
		
		ArrayList<BoardTO> lists 
			= (ArrayList)sqlSession.selectList("selectlist");
	
		if (sqlSession != null) sqlSession.close();
	
		return lists;
	}
	
	public BoardTO boardView(BoardTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();

			String sql = "update board1 set hit=hit+1 where seq=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			pstmt.executeUpdate();
			
			sql = "select subject, writer, mail, wip, wdate, hit, content from board1 where seq=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setMail(rs.getString("mail"));
				to.setWip(rs.getString("wip"));
				to.setWdate(rs.getString("wdate"));
				to.setHit(rs.getString("hit"));
				to.setContent(rs.getString("content") == null ? "" : rs.getString("content").replaceAll("\n", "<br />"));
			}
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( rs != null ) try{ rs.close(); } catch(SQLException e) {}
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}
		return to;
		
	}

	public BoardTO boardDelete(BoardTO to) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select subject, writer from board1 where seq=?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, to.getSeq());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
			}
		}catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( rs != null ) try{ rs.close(); } catch(SQLException e) {}
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}
		return to;		
	}

	public int boardDeleteOK(BoardTO to) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 2;
		try{
			conn = this.dataSource.getConnection();
			
			String sql = String.format("delete from board1 where seq= ? and password=?");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, to.getSeq());
			pstmt.setString(2, to.getPassword());
			
			int result = pstmt.executeUpdate();
			if(result == 0) {
				flag = 1;
			} else if( result == 1) {
				// 정상
				flag = 0;
			}			
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}
		return flag;
		
	}

	public BoardTO boardModify(BoardTO to) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {			
			conn = this.dataSource.getConnection();
			
			String sql = "select subject, writer, mail, wip, wdate, hit, content, password from board1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setMail(rs.getString("mail"));
				to.setPassword(rs.getString("password"));
				to.setContent(rs.getString("content").replaceAll("\n", "<br />"));
			}
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( rs != null ) try{ rs.close(); } catch(SQLException e) {}
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}
		return to;
	}

	public int boardModifyOK(BoardTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 2;
		
		try{			
			conn = this.dataSource.getConnection();
			
			String sql = "update board1 set subject = ?, mail = ?, content = ? where seq=? and password=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSubject());
			pstmt.setString(2, to.getMail());
			pstmt.setString(3, to.getContent());
			pstmt.setString(4, to.getSeq());
			pstmt.setString(5, to.getPassword());
			
			
			int result = pstmt.executeUpdate();
			if(result == 0) {
				// 비밀 번호를 잘못 기입한 경우
				flag = 1;
			} else if( result == 1) {
				// 정상
				flag = 0;
			}
			
		} catch( SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );		
		} finally{
			if( pstmt != null ) try{ pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try{ conn.close(); } catch(SQLException e) {}
		}
		return flag;
		
	}

}
