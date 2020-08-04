import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JDBCProject02 { 
	
	public static boolean getType(String msg) {
		return Pattern.matches("^[가-힣]*$", msg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner scanner = new Scanner( System.in );
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);		

			while( true ) {

				System.out.print( "동주소 입력 : " );
				String msg = scanner.next();	
				
				String sql = "select * from zipcode where dong like '" + msg + "%'";	

				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if( msg.equals("exit") ) {
					break;
				} else if(msg.length() < 2) {
					System.out.println("한글자 이상 입력해주세요");
				} else if( getType(msg)==false ) {
					System.out.println("한글로 입력해주세요");
				} else {
					while(rs.next()) {
						String result = String.format("%s  %s  %s  %s  %s  %s  %s", 
								rs.getString("zipcode"),
								rs.getString("sido"),
								rs.getString("gugun"),
								rs.getString("dong"),
								rs.getString("ri"),
								rs.getString("bunji"),
								rs.getString("seq")
								);
						System.out.println(result);
					}
				}
			}
			scanner.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( conn != null ) try { conn.close(); } catch (SQLException e) {}
			if( rs != null ) try { conn.close(); } catch (SQLException e) {}
		}
	}
}