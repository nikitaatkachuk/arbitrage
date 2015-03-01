package by.arbitrage.springconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Configuration
public class ThymeleafConfig
{
	@Bean
	public ServletContextTemplateResolver templateResolver()
	{
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("WEB-INF/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine()
	{
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new SpringSecurityDialect());
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		return resolver;
	}

	/*@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
		handlerAdapter.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter());
		return handlerAdapter;
	}*/

}
