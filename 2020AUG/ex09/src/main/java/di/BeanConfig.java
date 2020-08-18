package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.BoardTO;
import spring.WriteAction;

@Configuration
public class BeanConfig {
	
	@Bean
	public BoardTO to1() {
		BoardTO to = new BoardTO();
		to.setSeq(1);
		to.setSubject("제목1");
		return to;
	}
	
	@Bean
	public WriteAction writeAction() {
		WriteAction writeAction = new WriteAction();
		writeAction.setBoardTO(to1());
		return writeAction;
	}
}
