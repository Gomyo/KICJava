import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	private Connection conn = null;
	
	public EmpDAO() {
		// TODO Auto-generated constructor stub
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
				
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection( url, user, password );			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
	}
	
	// 2차원
	public String[][] allEmp() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[][] datas = new String[14][];
				
		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			int rowCount = 0;
			while( rs.next() ) {
				String empno = rs.getString( "empno" );
				String ename = rs.getString( "ename" );
				String job = rs.getString( "job" );
				String mgr = rs.getString( "job" );
				String hiredate = rs.getString( "hiredate" );
				String sal = rs.getString( "comm" );
				String comm = rs.getString( "comm" );
				String deptno = rs.getString( "deptno" );
				
				datas[rowCount] = new String[8];
				
				datas[rowCount][0] = empno;
				datas[rowCount][1] = ename;
				datas[rowCount][2] = job;
				datas[rowCount][3] = mgr;
				datas[rowCount][4] = hiredate;
				datas[rowCount][5] = sal;
				datas[rowCount][6] = comm;
				datas[rowCount][7] = empno;
				
				rowCount++;
			}
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {};
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {};
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {};
		}
		return datas;
	}
	
	public ArrayList<ArrayList<String>> allArrayListEmp() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ArrayList<String>> datas
			= new ArrayList<ArrayList<String>>();
				
		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				String empno = rs.getString( "empno" );
				String ename = rs.getString( "ename" );
				String job = rs.getString( "job" );
				String mgr = rs.getString( "job" );
				String hiredate = rs.getString( "hiredate" );
				String sal = rs.getString( "comm" );
				String comm = rs.getString( "comm" );
				String deptno = rs.getString( "deptno" );
				
				ArrayList<String> data = new ArrayList<String>();
				
				data.add( empno );
				data.add( ename );
				data.add( job );
				data.add( mgr );
				data.add( hiredate );
				data.add( sal );
				data.add( comm );
				data.add( deptno );
				
				datas.add( data );
			}
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {};
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {};
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {};
		}
		return datas;
	}
	
	public ArrayList<EmpTO> allEmpTO() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpTO> datas = new ArrayList<EmpTO>();
				
		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				String empno = rs.getString( "empno" );
				String ename = rs.getString( "ename" );
				String job = rs.getString( "job" );
				String mgr = rs.getString( "job" );
				String hiredate = rs.getString( "hiredate" );
				String sal = rs.getString( "comm" );
				String comm = rs.getString( "comm" );
				String deptno = rs.getString( "deptno" );
				
				EmpTO to = new EmpTO();
				to.setEmpno( empno );
				to.setEname( ename );
				to.setJob( job );
				to.setMgr( mgr );
				to.setHiredate( hiredate );
				to.setSal( sal );
				to.setComm( comm );
				to.setDeptno( deptno );
				
				datas.add( to );
			}
		} catch( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {};
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {};
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {};
		}
		return datas;
	}
}






