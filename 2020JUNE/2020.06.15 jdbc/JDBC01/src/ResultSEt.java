import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSEt {

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


			//					select empno, ename, job, sal* 12+ifnull(comm,0) from emp where deptno=10
			String deptno = "10";
			String sql = String.format("select empno,ename,job,sal*12+ifnull(comm,0) annual from emp where deptno=%s", deptno);

			rs = stmt.executeQuery(sql);
			// ResultSet �ȿ� ���� ���Ұ� ���� ��������
			while (rs.next()) {
				// ������ ������� �ʾƵ� ��
				String result = String.format("%s\t%s\t%s\t%s\n", 
						rs.getString("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						// ��Ī���� ��������
						// rs.getString("annual"));
						// ������ ��������
						rs.getString(4));
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
