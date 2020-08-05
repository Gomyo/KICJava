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
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
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
	
	public ArrayList<DTO> allZipcode(String strDong) {
		ArrayList<DTO> datas = new ArrayList<DTO>();
		try {
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strDong+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				DTO to = new DTO();
				
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
