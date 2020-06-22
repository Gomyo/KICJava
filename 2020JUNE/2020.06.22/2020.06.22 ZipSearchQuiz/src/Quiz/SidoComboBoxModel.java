package Quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class SidoComboBoxModel extends DefaultComboBoxModel<String> {
	
	private ArrayList<String> datas = new ArrayList<String>();
	// 데이터베이스 연결
	// 데이터 가져오기
	/*
	public CustomComboBoxModel() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    
		String url = "jdbc:mysql://192.168.0.37:3306/project";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName( "org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select distinct sido from zipcode";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				datas.add(rs.getString("sido"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
	*/
	
	// 생성자 Ver.2
	public SidoComboBoxModel() {
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.allSido();
	}
	
	@Override
	public int getSize() {
		return datas.size();
	}
	
	@Override
	public String getElementAt(int index) {
		return datas.get(index);
	}
}
