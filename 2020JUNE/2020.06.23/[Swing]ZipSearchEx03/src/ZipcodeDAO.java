import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public ZipcodeDAO() {
		// 데이터 연결
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		}
	}
	
	public ArrayList<String> byZipcode(String zipcode) {
		ArrayList<String> sidodatas = new ArrayList<String>();
		try {
			String sql = "select zipcode, sido, gugun, dong, ri from zipcode where zipcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zipcode);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sidodatas.add(rs.getString("sido"));
				sidodatas.add(rs.getString("gugun"));
				sidodatas.add(rs.getString("dong"));
			}
		} catch (SQLException e) {
			System.out.println("[에러] : "+e.getMessage());
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return sidodatas;
	}
}
