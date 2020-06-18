import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcResultSetReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// jdbc �ε�. ����̹��� �޸𸮿� �ø���.
				try {
					Class.forName("org.mariadb.jdbc.Driver");
					conn = DriverManager.getConnection(url, user, password);
					System.out.println("Database Connected");
					
					stmt = conn.createStatement();
					System.out.println("���� �Ϸ�");
					
					String deptno = "30";
					String sql = String.format("select * from dept2 where deptno=%s",deptno);
					
					rs = stmt.executeQuery(sql);
					// ResultSet �ȿ� ���� ���Ұ� ���� ��������
					while (rs.next()) {
						// ������ ������� �ʾƵ� ��
						String result = String.format("%s\t%s\t%s\n", 
								rs.getString("deptno"),
								rs.getString("dname"),
								rs.getString("loc"));
						System.out.println(result);
						/*
						System.out.printf(rs.getString("deptno"));
						System.out.println(rs.getString("dname"));
						System.out.println(rs.getString("loc"));
						*/
					}
					
					System.out.println("�Է� ����");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("[����] :"+e.getMessage());
				} catch (SQLException e) {
					System.out.println("[����] :"+e.getMessage());
				} finally {
					if (rs != null) try {rs.close();} catch(SQLException e) {}
					if (stmt != null) try {stmt.close();} catch(SQLException e) {}
					if (conn != null) try {conn.close();} catch(SQLException e) {}
				}
				System.out.println("End");
	}

}
