package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerEx01 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 톰캣이 끝나는 부분
		System.out.println("끝");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 톰캣이 시작되는 부분 
		System.out.println("시작");
	}

}
