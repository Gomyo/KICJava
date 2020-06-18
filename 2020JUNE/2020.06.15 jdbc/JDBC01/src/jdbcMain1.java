import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Connection conn= null;
		Statement stmt = null;
		
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
			/*
			�� ������Ʈ��Ʈ�� �̿��� ������ ������ (�ΰ��� ���)
			select
			executeQuery()
			��Ÿ ����
			excuteableUpdatae()
			*/
//			insert into dept2 values(10,'young','seoul');
//			String sql="insert into dept2 values(10,'young','seoul')";
			
			String deptno = "50";
			String dname = "Dine";
			String loc = "Bollywood";
			
			// �Ʒ��� �ڵ�� ���� �����ϴ�.
			String sql= "insert into dept2 values(" + deptno + ", '" + dname + "' , '" + loc + "')";
			// ���� �����ϰ� format method�� ����
//			String sql = String.format("insert into dept2 values( %s, '%s' ,'%s')", deptno, dname, loc);
			stmt.executeUpdate(sql);
			
			System.out.println("�Է� ����");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[����] :"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("[����] :"+e.getMessage());
		} finally {
			if (stmt != null) try {stmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
		System.out.println("Driver's Loading Success");
		
		System.out.println("End");
	}

}
