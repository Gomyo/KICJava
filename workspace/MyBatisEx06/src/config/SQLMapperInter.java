package config;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model1.DeptTO;
import model1.EmpTO;

public interface SQLMapperInter {
	
//	@Select ("select deptno, dname, loc from dept where deptno=10")
//	public DeptTO selectByDeptno();
	
	@Select ("select deptno, dname, loc from dept where deptno= #{deptno} ")
	public DeptTO selectByDeptno(String deptno);
	
	@Select ("select deptno, dname, loc from dept")
	public List<DeptTO> selectList();
//	@Select ("select deptno, dname, loc from #{dept}")
//	public List<DeptTO> selectList(String dept);
	
	// s로 시작하는 사원에 대한 정보 출력하기
	@Select ("select empno, ename, job from emp where ename like #{ename}")
	public List<EmpTO> selectEmpList(String ename);
	
	@Insert ("insert into dept2 values (#{deptno}, #{dname}, #{loc})")
	public int insert(DeptTO to);
	
	@Update ("update dept2 set dname=#{dname} where deptno=#{deptno}")
	public int update(DeptTO to);
	
	@Delete ("delete from dept2 where deptno=#{deptno}")
	public int delete(DeptTO to);
}