package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipSearchDAO {
	// DAO
	// 1. connection 객체를 가져다 쓰기 위해 미리 만들어 두기. DB에 접속하는 객체를 전용으로 하나만 만들고, 모든 페이지에서 이 객체를 호출해서 사용하면 효율적이다.
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ZipSearchDAO() {
		
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Service : 비지니스 로직
	public ArrayList<ZipSearchDTO> allEmp(String strDong) {
		ArrayList<ZipSearchDTO> datas = new ArrayList<ZipSearchDTO>();
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
				
				ZipSearchDTO to = new ZipSearchDTO();
				
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
