import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class preparedStatement {

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
			// 실행할 쿼리를 미리 입력해 준다.
			String sql = "insert into dept2 values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// set계열의 메소드를 사용해서 ?에 들어갈 값을 각각 지정해줘야 한다
			pstmt.setString(1, "70");
			pstmt.setString(2, "Conac");
			pstmt.setString(3, "San Margio");
			
			// sql이 없으니 주의하도록 한다
			pstmt.executeUpdate();
			
			pstmt.setString(1, "70");
			pstmt.setString(2, "Shanhai");
			pstmt.setString(3, "Zang Chen");
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
