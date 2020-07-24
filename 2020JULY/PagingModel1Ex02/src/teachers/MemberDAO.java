package teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSource = null;
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb2");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[DAO DB에러 : ]" + e.getLocalizedMessage());
		}
	}
	
	public boolean checkLogin(MemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select count(*) count from user where user = ? && password=password(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getId());
			pstmt.setString(2, to.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("count") == 1) {
					flag = true;
				}
			}
			
		} catch (SQLException e){
			
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}; 
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}; 
			if (conn != null) try {conn.close();} catch (SQLException e) {}; 
		}
		return flag;
		
	}
}
