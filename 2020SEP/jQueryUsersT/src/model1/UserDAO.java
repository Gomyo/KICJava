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

public class UserDAO {
	
	private DataSource dataSource = null;
	
	public UserDAO() {
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
	
	public ArrayList<UserTO> allUserInfo() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<UserTO> datas = new ArrayList<UserTO>();
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select * from users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String seq = rs.getString("seq");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				UserTO uto = new UserTO();
				
				uto.setSeq(seq);
				uto.setName(name);
				uto.setEmail(email);
				uto.setPassword(password);
				
				datas.add(uto);
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
	
	public int userWriteOk(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "insert into users values (0, ?, ?, ?)";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getName() );
			pstmt.setString( 2, to.getEmail() );
			pstmt.setString( 3, to.getPassword() );
			
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
	
		return flag;
	}
}
