package com.guorui.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

import com.guorui.springmvc.servlet.MyFilter;
import com.guorui.springmvc.servlet.MyListener;
import com.guorui.springmvc.servlet.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		Dynamic servlet = servletContext.addServlet("MyServlet", MyServlet.class);
		servlet.addMapping("/myservlet");
		
		javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("MyFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/myservlet");
		
		servletContext.addListener(MyListener.class);
	}

}
