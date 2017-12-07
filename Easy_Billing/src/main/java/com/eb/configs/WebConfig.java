package com.eb.configs;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages= {"com.eb.controllers"})

public class WebConfig extends WebMvcConfigurationSupport{

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		
		registry.jsp("/WEB-INF/JSPs/", ".jsp");
	
	}

	
	
	

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	

	
	
}
