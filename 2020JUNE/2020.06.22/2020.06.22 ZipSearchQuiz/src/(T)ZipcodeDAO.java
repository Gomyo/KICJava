import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	private Connection conn = null;
	
	public ZipcodeDAO() {
		// TODO Auto-generated constructor stub
		// 데이터 연결
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
				
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection( url, user, password );			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
	}
	
	public ArrayList<String> allSido() {
		// sido 데이터 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> datas = new ArrayList<String>();
		
		try {
			String sql = "select distinct sido from zipcode";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				datas.add( rs.getString("sido") );
			}
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {};
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {};
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {};
		}
		return datas;
	}
}






