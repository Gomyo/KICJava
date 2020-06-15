import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Connection conn= null;
		Statement stmt = null;
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		// jdbc 로딩. 드라이버를 메모리에 올린다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			
			stmt = conn.createStatement();
			System.out.println("생성 완료");
			
			// String으로 통일
			String empno = "30";
			String ename = "Joon";
			String job = "Developer";
			String mgr = "30";
			String hiredate = "2020-06-15";
			String sal = "330";
			String comm = "20";
			String deptno = "80";
					
			
			String sql = String.format("insert into emp2 values( %s, '%s' ,'%s', '%s', '%s', '%s', '%s', '%s')", empno, ename, job,mgr,hiredate,sal,comm,deptno);
			stmt.executeUpdate(sql);
			
			System.out.println("입력 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] :"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("[에러] :"+e.getMessage());
		} finally {
			if (stmt != null) try {stmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
		System.out.println("Driver's Loading Success");
		
		System.out.println("End");
	}

}
