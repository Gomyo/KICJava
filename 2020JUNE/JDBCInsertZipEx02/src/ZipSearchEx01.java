import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipSearchEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
        
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
        
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
        
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			conn = DriverManager.getConnection( url, user, password );
			stmt = conn.createStatement();

			String sql = "select * from zipcode where sido";
			rs = stmt.executeQuery( sql );
			while( rs.next() ) {
				System.out.printf( "[%s] %s %s %s %s %s%n", rs.getString( "zipcode" ), rs.getString( "sido" ), rs.getString( "gugun" ), rs.getString( "dong" ), rs.getString( "ri" ), rs.getString( "bunji" ) );
			}
		} catch( ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage() );
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( stmt != null ) try { stmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
	}

}
