import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcupdatepreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// jdbc 로딩. 드라이버를 메모리에 올린다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			// 문제 : update dept2 set loc='분당' where deptno=20; 를 preparedStatement로 구현
			String sql = "update dept2 set loc=? where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "분당");
			pstmt.setString(2, "30");
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("[에러] :"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("[에러] :"+e.getMessage());
		} finally {
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
		System.out.println("End");
	}
}
