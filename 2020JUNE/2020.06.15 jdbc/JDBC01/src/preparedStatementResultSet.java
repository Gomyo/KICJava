import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class preparedStatementResultSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// jdbc �ε�. ����̹��� �޸𸮿� �ø���.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			
			String sql = "select * from dept2 where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "20");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("deptno"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("[����] :"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("[����] :"+e.getMessage());
		} finally {
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
		System.out.println("End");
	}
}
