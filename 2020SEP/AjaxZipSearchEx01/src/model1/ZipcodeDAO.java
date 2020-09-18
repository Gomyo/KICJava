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

public class ZipcodeDAO {
	
	private DataSource dataSource = null;
	
	public ZipcodeDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/ubuntu");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[DAO DB에러 : ]" + e.getLocalizedMessage());
		}
	}
	
	public ArrayList<ZipcodeTO> allZipcode(ZipcodeTO pto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipcodeTO> datas = new ArrayList<ZipcodeTO>();
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pto.getDong() +"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				ZipcodeTO to = new ZipcodeTO();
				
				to.setZipcode(zipcode);
				to.setSido(sido);
				to.setGugun(gugun);
				to.setDong(dong);
				to.setRi(ri);
				to.setBunji(bunji);
				
				datas.add(to);
			}
		}
		catch (SQLException e) {
			System.out.println("[에러] : "+e.getMessage());
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return datas;
	}
}
