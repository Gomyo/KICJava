import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatisEx01_select {
	public static void main(String[] args) {
		String resource = "myBatisConfig.xml";
		
		Reader reader = null;
		SqlSession sqlSession = null;
		
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory 
				= new SqlSessionFactoryBuilder().build(reader);
			
			sqlSession = sqlSessionFactory.openSession(true);
			
			List<Map> lists = sqlSession.selectList("mybatis2.selectlist2","SCOTT");
			for (int i=0; i<lists.size(); i++) {
				Map map = lists.get(i);
				Set<String> keys = map.keySet();
				for (String key : keys) {
					System.out.print(map.get(key) + "\t");
				}
				System.out.println("");
//				Map map = lists.get(i);
//				System.out.printf("%s\t%s\t%s\n"
//						, map.get("deptno")
//						, map.get("dname")
//						, map.get("loc"));
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
