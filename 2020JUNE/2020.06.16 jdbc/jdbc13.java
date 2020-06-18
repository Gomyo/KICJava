import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc13 {

	public static void main(String[] args) {
		
		//접속을 위한 문자열
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		Connection conn =null;			// 이거뜻
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			DatabaseMetaData dmd =conn.getMetaData();			// 데이터를 가져옴?
			
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDatabaseProductVersion());		//데이터의 종류파악 23 ~ 30
			
			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());
			
			System.out.println(dmd.getURL());
			System.out.println(dmd.getUserName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
	}

}
