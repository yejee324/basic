package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class hsListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("listener contextDestroyedcontextDestroyedcontextDestroyed");
		ServletContextListener.super.contextDestroyed(sce);
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("listener contextInitializedcontextInitializedcontextInitialized");
		ServletContextListener.super.contextInitialized(sce);
	}
}
