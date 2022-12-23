package kr.or.ddit.basic;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener{
	
	public MyServletContextListener() {
		System.out.println("[MyServletContextListener] 생성자 호출됨.");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println(
				"[MyServletContextListener] 서블릿 컨텍스트 객체가 제거되었음.");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(
				"[MyServletContextListener] 서블릿 컨텍스트 객체가 초기화되었음.");
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println(
				"[MyServletContextListener] 서블릿 컨텍스트에 속성 추가되었음. => "
				+ event.getName() + " : " + event.getValue());
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println(
				"[MyServletContextListener] 서블릿 컨텍스트에 속성 제거되었음. => "
				+ event.getName() + " : " + event.getValue());
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println(
				"[MyServletContextListener] 서블릿 컨텍스트에 속성 변경되었음. => "
				+ event.getName() + " : " + event.getValue());
		
	}

}
