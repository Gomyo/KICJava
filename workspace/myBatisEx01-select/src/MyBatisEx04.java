

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx04 {

	public static void main(String[] args) {
		String resource = "myBatisConfig.xml";
		
		InputStream is =null;
		SqlSession sqlSession = null;
		
		try {
			is = Resources.getResourceAsStream( resource );
			
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(is);
			System.out.println("호출 성공");
			
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("연결 성공");
			
			List<Map> lists = sqlSession.selectList("selectlist","S%");
			for (int i=0; i<lists.size(); i++) {
				Map map = lists.get(i);
				
				System.out.println(map.get("zipcode"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("에러 : " + e.getMessage());
		} finally {
			if (is != null) try {is.close();} catch(IOException e) {}
			if (sqlSession != null) sqlSession.close();
		}
	}

}
