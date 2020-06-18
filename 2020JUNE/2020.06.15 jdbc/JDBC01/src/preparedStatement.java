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
		
		// jdbc �ε�. ����̹��� �޸𸮿� �ø���.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			// ������ ������ �̸� �Է��� �ش�.
			String sql = "insert into dept2 values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// set�迭�� �޼ҵ带 ����ؼ� ?�� �� ���� ���� ��������� �Ѵ�
			pstmt.setString(1, "70");
			pstmt.setString(2, "Conac");
			pstmt.setString(3, "San Margio");
			
			// sql�� ������ �����ϵ��� �Ѵ�
			pstmt.executeUpdate();
			
			pstmt.setString(1, "70");
			pstmt.setString(2, "Shanhai");
			pstmt.setString(3, "Zang Chen");
			pstmt.executeUpdate();

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
