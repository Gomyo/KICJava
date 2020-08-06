package config;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model1.ZipcodeTO;

public interface SQLMapperInter {
	
	@Select ("select * from zipcode where dong like #{dong}")
	public ArrayList<ZipcodeTO> selectList(String dong);
}