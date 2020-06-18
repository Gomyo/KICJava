import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SearchDong_Scanner {
   
   public static boolean getType(String s) {
      return Pattern.matches("^[가-힣]*$", s);
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Scanner sc = new Scanner(System.in);
      
      String url ="jdbc:mysql://localhost:3306/project";
      String user="root";
      String password="123456";
      
      try {
         
         Class.forName("org.mariadb.jdbc.Driver");
         
         conn=DriverManager.getConnection(url, user, password);
         
         String sql ="select * from zipcode where dong like ?";
         pstmt = conn.prepareStatement(sql);
      
            // while(true) -> 무한 반복
            // 반복문 ->break 사용 가능/ if는 조건문이기 때문에 사용 불가능!
            while(true) {
               System.out.println("우편번호 찾기 (동 이름 입력) : ");
               String s = sc.nextLine();
               pstmt.setString(1, s+"%");
               pstmt.executeUpdate();
               rs=pstmt.executeQuery();
               
               if(s.equals("exit")){
               sc.close();
               System.out.println("검색을 종료합니다");
               break;
               }
               if(getType(s)==false) {
               System.out.println("한글로 검색해 주세요");
               continue; //계속 검색 가능하게 스킵하고 계속 밑으로~
               }
               if(s.length()==0 || s.length()==1) {
               System.out.println("동 이름을 두 글자 이상 입력하세요");
               continue; //계속 검색 가능하게 스킵하고 계속 밑으로~
               }
               else {
                  while(rs.next()) {
                     String result=
                           String.format("'%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
                                 rs.getString("zipcode"),
                                 rs.getString("sido"),
                                 rs.getString("gugun"),
                                 rs.getString("dong"),
                                 rs.getString("ri"),
                                 rs.getString("bunji"),
                                 rs.getString("seq"));
                           System.out.println(result);
            }
            System.out.println("검색 완료!");
         }
      }
      }catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         System.out.println("에러 : "+e.getMessage());
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("에러 : "+e.getMessage());
      }finally {
         if(conn != null) try {conn.close();} catch(SQLException e) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
         if(rs != null) try {rs.close();} catch(SQLException e) {}
      }
    }
}