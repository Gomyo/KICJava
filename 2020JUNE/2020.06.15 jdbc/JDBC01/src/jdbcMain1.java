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
		// jdbc 로딩. 드라이버를 메모리에 올린다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			
			stmt = conn.createStatement();
			System.out.println("생성 완료");
			/*
			이 스테이트먼트를 이용해 쿼리를 던진다 (두가지 방식)
			select
			executeQuery()
			기타 전부
			excuteableUpdatae()
			*/
//			insert into dept2 values(10,'young','seoul');
//			String sql="insert into dept2 values(10,'young','seoul')";
			
			String deptno = "50";
			String dname = "Dine";
			String loc = "Bollywood";
			
			// 아래의 코드는 조금 복잡하다.
			String sql= "insert into dept2 values(" + deptno + ", '" + dname + "' , '" + loc + "')";
			// 조금 간단하게 format method를 쓰자
//			String sql = String.format("insert into dept2 values( %s, '%s' ,'%s')", deptno, dname, loc);
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
