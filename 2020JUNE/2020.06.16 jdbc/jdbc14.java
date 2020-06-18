import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class jdbc14 {

	public static void main(String[] args) {
		
		//접속을 위한 문자열
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		Connection conn =null;			// 이거뜻 17~19 ?
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from zipcode";			//select문을 작성
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();					// 26~27행 ?
			
			ResultSetMetaData rsmd = rs.getMetaData();		//
			System.out.println(rsmd.getColumnCount()); 		//컬럼의 갯수 확인
			
			// 이걸이용해서 dscribe 를 만들수있음 44행
			for(int i=1; i<=rsmd.getColumnCount();i++) {
				//System.out.println(rsmd.getColumnName(i));   	// 전체 컬럼 이름 확인
				//System.out.println(rsmd.getColumnLabel(i));       //getColumnName 이랑 같음
				//System.out.println(rsmd.getColumnTypeName(i));   // 컬럼의 타입이름확인
				//System.out.println(rsmd.getPrecision(i));   	// 컬럼의 크기값
				//System.out.println(rsmd.getScale(i));
				
				//System.out.println(rsmd.isNullable(i));  		// null의 허용여부
				
				System.out.printf("%-10s %s(%d)%n",rsmd.getColumnName(i),rsmd.getColumnTypeName(i),rsmd.getColumnDisplaySize(i));	//%-10s는뭐지?
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("에러"+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("에러"+e.getMessage());
		} finally {
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
		}
		
	}

}
// 결과셋에 관한이야기
