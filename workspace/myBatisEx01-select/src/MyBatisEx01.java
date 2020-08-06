

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx01 {

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
			
//			DeptTO to = (DeptTO)sqlSession.selectOne("select1");
//			DeptTO to = (DeptTO)sqlSession.selectOne("mybatis.select1");
//			DeptTO to = (DeptTO)sqlSession.selectOne("select2", "20");
			DeptTO pto = new DeptTO();
			pto.setDeptno("20");
			pto.setDname("ACCOUNTING");
			DeptTO to = (DeptTO)sqlSession.selectOne("select3", pto);
			
			if (to != null) {
				System.out.println(to.getDeptno());
				System.out.println(to.getDname());
				System.out.println(to.getLoc());
			} else {
				System.out.println("There's no data.");
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
