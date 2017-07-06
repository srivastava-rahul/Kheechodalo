package com.click.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { // implements
																								// WebApplicationInitializer
																								// {

	/*
	 * public void onStartup(ServletContext servletContext) throws
	 * ServletException {
	 * 
	 * //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	 * 
	 * AnnotationConfigWebApplicationContext ctx = new
	 * AnnotationConfigWebApplicationContext(); ctx.register(WebConfig.class);
	 * ctx.setServletContext(servletContext);
	 * 
	 * DispatcherServlet dp = new DispatcherServlet(ctx);
	 * dp.setThrowExceptionIfNoHandlerFound(true);
	 * 
	 * Dynamic dynamic = servletContext.addServlet("dispatcher", dp);
	 * dynamic.addMapping("/"); dynamic.setLoadOnStartup(1);
	 * 
	 * //servletContext.addListener(HttpSessionEventPublisher.class);
	 * 
	 * }
	 */

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
	}

}
