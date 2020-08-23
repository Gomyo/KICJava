package model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CommentDAO {
	private DataSource dataSource = null;
	
	public CommentDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb1");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[DAO DB에러 : ]" + e.getLocalizedMessage());
		}
	}
	public int commentWriteOk(CommentDTO dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "insert into comment_board values(?,0,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());
			pstmt.setString(2, dto.getCwriter());
			pstmt.setString(3, dto.getCpassword());
			pstmt.setString(4, dto.getCcontent());
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				flag = 0;
			} 
		} catch (SQLException e) { 
			System.out.println("[write에러] : "+e.getMessage());
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return flag;
	}
	public CommentDTO commentlist(CommentDTO commentlistDTO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalComments = 0;
		
		try {
			conn = this.dataSource.getConnection();
			String sql = "select comment_seq, writer, wdate, content from comment_board where seq=? order by comment_seq desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentlistDTO.getSeq());
			rs = pstmt.executeQuery();
			
			rs.last();
			totalComments = rs.getRow();
			rs.beforeFirst();
			
			ArrayList<CommentDTO> clists = new ArrayList<CommentDTO>();
		
			while (rs.next()) {
				CommentDTO cdto = new CommentDTO();
				cdto.setCommentSeq(rs.getString("comment_seq"));
				cdto.setCwriter(rs.getString("writer"));
				cdto.setWdate(rs.getString("wdate"));
				cdto.setCcontent(rs.getString("content"));
				clists.add(cdto);
//				System.out.println(cdto);
			}
//			System.out.println(clists);
			commentlistDTO.setCommentAll(totalComments);
			commentlistDTO.setCommentList(clists);
				
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return commentlistDTO;
	}
}
