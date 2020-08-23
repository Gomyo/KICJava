package model1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BoardDAO {
	
	private SqlSession sqlSession;
	
	public BoardDAO() {
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
	
	public void boardWriter() {
		
	}
	
	public int boardWriterOK(BoardTO to) {
		
		int flag = 1;
		
		int result = sqlSession.insert("write_ok",to);
		
		if (sqlSession != null) sqlSession.close();
		
		if(result == 1) {
			flag = 0;
		}
		return flag;
	}
	
	public ArrayList<BoardTO> boardList() {
		
		ArrayList<BoardTO> lists 
			= (ArrayList)sqlSession.selectList("selectlist");
	
		if (sqlSession != null) sqlSession.close();
	
		return lists;
	}
	
	public BoardTO boardView(BoardTO to) {
	
		sqlSession.update("view_hit", to);
		
		to = sqlSession.selectOne("view" , to);
		
		if (sqlSession != null) sqlSession.close();
		
		return to;
		
	}

	public BoardTO boardDelete(BoardTO to) {
		
		to = sqlSession.selectOne("delete_view",to);
		
		if (sqlSession != null) sqlSession.close();
		
		return to;		
	}

	public int boardDeleteOK(BoardTO to) {
		
		int flag = 2;
		
		int result = sqlSession.delete("delete_ok",to);
		
		if (sqlSession != null) sqlSession.close();
		
		if(result == 0) {
			flag = 1;
		} else if( result == 1) {
			// 정상
			flag = 0;
		}			
		return flag;
	}

	public BoardTO boardModify(BoardTO to) {
		
		to = sqlSession.selectOne("modify_view",to);
		
		if (sqlSession != null) sqlSession.close();
		
		return to;
	}

	public int boardModifyOK(BoardTO to) {
		
		int flag = 2;
		
		int result = sqlSession.update("modify_ok",to);
		
		if (sqlSession != null) sqlSession.close();
		
		if(result == 0) {
			// 비밀 번호를 잘못 기입한 경우
			flag = 1;
		} else if( result == 1) {
			// 정상
			flag = 0;
		}
		return flag;
		
	}

}
