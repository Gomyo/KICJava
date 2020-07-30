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

public class BoardDAO {
	// 1. 메서드를 각각 생성한다.
	// 2. DB connection을 한 뒤, 데이터 소스를 가져온다.
	private DataSource dataSource = null;

	public BoardDAO() {
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

	public int boardWriteOk(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;

		try {
			conn = this.dataSource.getConnection();

			/*
			 * 데이터소스를 얻는 부분 => DAO로 Context initCtx = new InitialContext(); Context envCtx =
			 * (Context)initCtx.lookup( "java:comp/env" ); DataSource dataSource =
			 * (DataSource)envCtx.lookup( "jdbc/mariadb1" );
			 */

			String sql = "insert into board values (0, ?, ?, ?, ?, ?, 0, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getMail());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getWip());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				flag = 0;
			}

		} catch (SQLException e) {
			System.out.println("[DAO sql 에러] : " + e.getMessage());
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

	public ArrayList<BoardDTO> boardList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BoardDTO> lists = new ArrayList<BoardDTO>();
		try {
			conn = this.dataSource.getConnection();
			String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				dto.setWgap(rs.getInt("wgap"));
				// 최종적으로 ArrayList에 담는다.
				lists.add(dto);
			}
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
		return lists;
	}

	public BoardDTO boardView(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();

			String sql = "update board set hit=hit+1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());
			pstmt.executeUpdate();

			sql = "select subject, writer, mail, wip, wdate, hit, content from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setMail(rs.getString("mail"));
				dto.setWip(rs.getString("wip"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				dto.setContent(rs.getString("content").replaceAll("\n", "<br />"));
			}
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
		return dto;
	}

	public BoardDTO boardModify(BoardDTO dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();

			String sql = "select subject, writer, mail, content from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				if (rs.getString("mail").equals("")) {
					dto.setModifyMail(new String[] { "", "" });
				} else {
					dto.setModifyMail(rs.getString("mail").split("@"));
				}
				dto.setContent(rs.getString("content").replaceAll("\n", "<br />"));
			}
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
		return dto;
	}

	public int boardModifyOk(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 2;
		try {
			conn = dataSource.getConnection();
			
			String sql = "update board set subject=?, mail=?, content=? where seq=? and password=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, dto.getSubject() );
			pstmt.setString( 2, dto.getMail() );
			pstmt.setString( 3, dto.getContent() );
			pstmt.setString( 4, dto.getSeq() );
			pstmt.setString( 5, dto.getPassword() );
			
			int result = pstmt.executeUpdate();
			if( result == 0 ) {
				flag = 1; 
			} else if( result == 1 ) {
				flag = 0;
			}

		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
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

	public BoardDTO boardDelete(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();

			String sql = "select subject, writer from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
			}
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
		return dto;
	}

	public int boardDeleteOk(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 2;

		try {
			conn = this.dataSource.getConnection();

			String sql = "delete from board where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());
			pstmt.setString(2, dto.getPassword());

			int result = pstmt.executeUpdate();
			if (result == 0) {
				flag = 1;
			} else if (result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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
}
