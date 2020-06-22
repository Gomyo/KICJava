package Quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	// 생성자가 가동되는 순간 데이터베이스 커넥션 시작
	// 이 커넥션을 이용해서 셀렉션 (39th line) 시작
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
	public ArrayList<String> allSido() {
		// sido 데이터 검색
		ArrayList<String> sidodatas = new ArrayList<String>();
		try {
			String sql = "select distinct sido from zipcode";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sidodatas.add(rs.getString("sido"));
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
	
	public ArrayList<String> allGugun(String sido) {
		ArrayList<String> gugundatas = new ArrayList<String>();
		// gugun 데이터 검색
		try {
			String sql = "select distinct gugun from zipcode where sido = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sido);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				gugundatas.add(rs.getString("gugun"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : "+e.getMessage());
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return gugundatas;
	}
	
	public ArrayList<String> allDong(String gugun) {
		ArrayList<String> dongdatas = new ArrayList<String>();
		// dong 데이터 검색
		try {
			String sql = "select distinct dong from zipcode where gugun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gugun);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dongdatas.add(rs.getString("dong"));
			}
		} catch (SQLException e) {
			System.out.println("[에러] : "+e.getMessage());
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return dongdatas;
	}
	
}
