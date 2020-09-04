import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatisEx01 {
	public static void main(String[] args) {
		String resource = "myBatisConfig.xml";
		
		InputStream is = null;
		SqlSession sqlSession = null;
		
		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = sqlSessionFactory.openSession(true);
			
			DeptTO to = new DeptTO();
			to.setDeptno("81");
			to.setDname("철구");
			to.setLoc("태국");
			
			// 영향받은 행수 : 거의 1
			int result = sqlSession.insert("insert1", to);
			if (result == 1) {
//				sqlSession.commit();
				System.out.println("데이터 넣기 성공");
			} else {
				System.out.println("데이터 넣기 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) try {is.close();} catch(IOException e) {}
		}
	}
}
