import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcpSRSlike {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// jdbc 로딩. 드라이버를 메모리에 올린다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			
			
			String sql = "select * from emp where ename like ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "s%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String result = String.format("%s\t%s\t%s\n", 
						rs.getString("empno"),
						rs.getString("ename"),
						rs.getString("job"));
				System.out.println(result);
			}

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
