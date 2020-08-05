import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatisEx04_delete {
	public static void main(String[] args) {
		String resource = "myBatisConfig.xml";
		
		Reader reader = null;
		SqlSession sqlSession = null;
		
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory 
				= new SqlSessionFactoryBuilder().build(reader);
			
			sqlSession = sqlSessionFactory.openSession(true);
			
			DeptTO to = new DeptTO();
			to.setDeptno("119");
			
			int result = sqlSession.insert("mybatis1.delete", to);
			if (result == 1) {
				System.out.println("데이터 삭제 성공");
			} else {
				System.out.println("데이터 삭제 실패");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) sqlSession.close();
			if (reader != null) try {reader.close();} catch (IOException e) {}
		}
		
				
	}
}
