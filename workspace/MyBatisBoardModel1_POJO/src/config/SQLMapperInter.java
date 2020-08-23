package config;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model1.BoardTO;

public interface SQLMapperInter {
	
	@Select ("select * from board1 order by seq desc")
	public ArrayList<BoardTO> selectList();
	
	@Update ("update board1	set hit=hit+1 where seq = #{seq}")
	public void updateViewHit(BoardTO to);
	
	@Select ("select seq, subject, writer, mail, wip, wdate, hit, content from board1 where seq = #{seq}")
	public BoardTO selectView(BoardTO to);  
	
	@Insert ("insert into board1 \r\n" + 
			"		values( 0, #{subject}, #{writer}, #{mail}, #{password}, #{content}, 0, #{wip}, now())")
	public int insertWrite(BoardTO to);
	
	@Select ("select subject, writer, mail, wip, wdate, hit, content, seq, password from board1 where seq=#{seq}")
	public BoardTO selectModify(BoardTO to);
	
	@Update ("update board1\r\n" + 
			"		set subject=#{subject}, mail=#{mail}, content=#{content}\r\n" + 
			"		where password=#{password} and seq=#{seq}")
	public int updateModify(BoardTO to);
	
	@Select ("select subject, writer from board1 where seq=#{seq}")
	public BoardTO selectDelete(BoardTO to);
	
	@Delete ("delete from board1\r\n" + 
			"		where password=#{password} and seq=#{seq}")
	public int deletePost(BoardTO to);
}