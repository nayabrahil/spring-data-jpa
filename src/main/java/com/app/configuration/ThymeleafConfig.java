package com.app.configuration;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter implements ServletContextAware {

	private static ServletContext servletContext;

	  @Bean
	  public ViewResolver viewResolver() {
	    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	    resolver.setTemplateEngine(templateEngine());
	    resolver.setCharacterEncoding("UTF-8");
	    return resolver;
	  }

	  private TemplateEngine templateEngine() {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setTemplateResolver(templateResolver());
	    return engine;
	  }

	  private ITemplateResolver templateResolver() {
	    ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(ThymeleafConfig.servletContext);
	    resolver.setPrefix("/WEB-INF/template/");
	    resolver.setSuffix(".html");
	    resolver.setTemplateMode(TemplateMode.HTML);
	    return resolver;
	  }
	  
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		ThymeleafConfig.servletContext = servletContext;
	}
}
