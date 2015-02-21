package by.arbitrage.springconfig;

import by.arbitrage.context.ApplicationContextProvider;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Nikita Tkachuk
 */
public class SpringMVCInitializer implements WebApplicationInitializer
{
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(WebAppConfig.class);
		ApplicationContextProvider.getInstance().setApplicationContext(annotationConfigWebApplicationContext);
		servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));
		servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null,false,"/*");

		annotationConfigWebApplicationContext.setServletContext(servletContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(annotationConfigWebApplicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
