package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WriteAction implements BoardAction, ApplicationContextAware, BeanFactoryAware, BeanNameAware, DisposableBean, InitializingBean{
	private String writer;
	private String beanName;
	private BeanFactory beanFactory;
	
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println("1. Start Bean's constructor");
	}
	
	public void setWriter(String writer) {
		System.out.println("2. setWriter(String writer) 실행 ");
		this.writer = writer;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("execute 실행");
		
		System.out.println("beanName : " + beanName);
		System.out.println("beanFactory : " + beanFactory);
		
		System.out.println("writer :" + this.writer);
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("7. afterPropertiesSet 실행");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("10. destroy() 실행");
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("3. setBeanName 실행");
		this.beanName = name;
		System.out.println("beanName : " + beanName);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("4. setBeanFactory() 실행");
		this.beanFactory = beanFactory;
		System.out.println("beanFactory : " + beanFactory);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("5. setApplicationContext() 실행");
	}

}
