package model1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ZipcodeDAO {
	
	private SqlSession sqlSession;
	
	public ZipcodeDAO() {
		String resource = "myBatisConfig.xml";
		
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			this.sqlSession = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) try {is.close();} catch (IOException e) {}
		}
	}
	
	public ArrayList<ZipcodeTO> allZipcode(ZipcodeTO pto) {
		
		ArrayList<ZipcodeTO> lists
			= (ArrayList)sqlSession.selectList("selectlist1", pto.getDong());
		
		if (sqlSession != null) sqlSession.close();
		
		return lists;
	}
}
	

