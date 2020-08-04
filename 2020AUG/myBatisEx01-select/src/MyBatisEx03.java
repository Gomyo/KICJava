

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx03 {

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
			/*
			List<DeptTO> lists = sqlSession.selectList("selectlist1");
			for (DeptTO to : lists) {
				System.out.println(to.getDeptno());
				System.out.println(to.getDname());
				System.out.println(to.getLoc());
			}*/
			
//			List<DeptTO> lists = sqlSession.selectList("selectlist2","S");
			List<EmpTO> lists = sqlSession.selectList("selectlist3","S%");
			
			for (EmpTO to : lists) {
				System.out.println(to.getEmpno());
				System.out.println(to.getEname());
				System.out.println(to.getJob());
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
