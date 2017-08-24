package com.click.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);
		ctx.setServletContext(servletContext);

		DispatcherServlet dp = new DispatcherServlet(ctx);
		dp.setThrowExceptionIfNoHandlerFound(true);

		Dynamic dynamic = servletContext.addServlet("dispatcher", dp);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);

	}

/*public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses");
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()");
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings()");
		return new String[] { "/" };
	}*/

}
