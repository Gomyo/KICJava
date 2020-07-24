package pageModel1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pageModel1.BoardDTO;

public class BoardDAO {
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
			
			String sql = "insert into emoji_board values(0,?,?,?,?,?,?,0,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getMail());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getEmot());	
			pstmt.setString(7, dto.getWip());	
			
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
	public BoardListDTO boardList(BoardListDTO listDTO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cpage = listDTO.getCpage();
		int recordPerPage = listDTO.getRecordPerPage();
		int blockPerPage = listDTO.getBlockPerPage();
		
		try {
			conn = this.dataSource.getConnection();
			String sql = "select seq, subject, writer, emot, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from emoji_board order by seq desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.last();
			listDTO.setTotalRecord(rs.getRow());
			rs.beforeFirst();
			
			listDTO.setTotalPage(((listDTO.getTotalRecord() -1)/recordPerPage) + 1);
			
			int skip = ((cpage -1)*recordPerPage);
			if (skip != 0) {
				rs.absolute(skip);
			}
			
			ArrayList<BoardDTO> lists = new ArrayList<BoardDTO>();
			
			for (int i=0; i<recordPerPage && rs.next(); i++) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setEmot(rs.getString("emot"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				dto.setWgap(rs.getInt("wgap"));
				// 최종적으로 ArrayList에 담는다.
				lists.add(dto);
			}
			listDTO.setBoardLists(lists);
			listDTO.setStartBlock(((cpage-1)/blockPerPage)*blockPerPage + 1);
			listDTO.setEndBlock(((cpage-1)/blockPerPage)*blockPerPage + blockPerPage);
			if (listDTO.getEndBlock() >= listDTO.getTotalPage()) {
				listDTO.setEndBlock(listDTO.getTotalPage());
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
		return listDTO;
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

			sql = "select subject, writer, mail, wip, wdate, emot, hit, content from emoji_board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setMail(rs.getString("mail"));
				dto.setWip(rs.getString("wip"));
				dto.setWdate(rs.getString("wdate"));
				dto.setEmot(rs.getString("emot"));
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
			conn = dataSource.getConnection();
			
			String sql = "select subject,emot,writer,mail,content from emoji_board where seq=?";
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
				dto.setEmot(rs.getString("emot"));
				String emot = rs.getString("emot");
				String emots = "";
				int emotInt = Integer.parseInt(emot);
				int emotsCnt = 1;
				for (int i=1; i<=3; i++) {
					emots += "<tr>";
					for (int j=1; j<=15; j++) {
						if (emotInt == emotsCnt) {
							if (emotsCnt <=9) {
								emots += "<td><img src='../../images/emoticon/emot0"+Integer.toString(emotsCnt)+".png' width='25' /><br /> <input type='radio' name='emot' value='emot" +Integer.toString(emotsCnt)+"' class='input_radio' checked='checked'/></td>";
							} else {
								emots += "<td><img src='../../images/emoticon/emot"+Integer.toString(emotsCnt)+".png' width='25' /><br /> <input type='radio' name='emot' value='emot" +Integer.toString(emotsCnt)+"' class='input_radio' checked='checked'/></td>";
							}
						} else if (emotsCnt <=9) {
							emots += "<td><img src='../../images/emoticon/emot0"+Integer.toString(emotsCnt)+".png' width='25' /><br /> <input type='radio' name='emot' value='emot" +Integer.toString(emotsCnt)+"' class='input_radio' /></td>";
						} else {
							emots += "<td><img src='../../images/emoticon/emot"+Integer.toString(emotsCnt)+".png' width='25' /><br /> <input type='radio' name='emot' value='emot" +Integer.toString(emotsCnt)+"' class='input_radio' /></td>";
						}
						emotsCnt++;
					}
					emots += "</tr>";
				}
				dto.setEmots(emots);
			}
		} catch (SQLException e) { 
			System.out.println("[modify1에러] : "+e.getMessage());
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
			
			String sql = "update emoji_board set subject=?, mail=?, content=?, emot=? where seq=? and password=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, dto.getSubject() );
			pstmt.setString( 2, dto.getMail() );
			pstmt.setString( 3, dto.getContent() );
			pstmt.setString( 4, dto.getEmot() );
			pstmt.setString( 5, dto.getSeq() );
			pstmt.setString( 6, dto.getPassword() );
			
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

			String sql = "select subject, writer from emoji_board where seq=?";
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

			String sql = "delete from emoji_board where seq=? and password=?";
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

