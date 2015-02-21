package by.arbitrage.springconfig;

import by.arbitrage.context.ApplicationContextProvider;
import by.arbitrage.context.UserContext;
import by.arbitrage.facade.EntryFacade;
import by.arbitrage.service.user.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by Nikita Tkachuk
 */
@Configuration
@EnableWebMvc
@Import({ThymeleafConfig.class, SpringDataConfig.class, SecurityConfig.class})
@ComponentScan(basePackages = {"by.arbitrage"})
@PropertySource("classpath:dbconnect.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySources = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] {
				new ClassPathResource("dbconnect.properties") };
		propertySources.setLocations(resources);
		propertySources.setIgnoreUnresolvablePlaceholders(true);
		return propertySources;
	}
	// Provides internationalization of messages
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

	/*@Bean
	public ApplicationContextProvider applicationContextProvider()
	{
		return ApplicationContextProvider.getInstance();
	}*/


	@Bean
	public UserDetailsService userDetailService()
	{
		return new UserDetailsServiceImpl();
	}

	@Bean
	public UserContext userContext()
	{
		UserContext context = new UserContext();
		//context.setAuthentication();
		return context;
	}

	/*@Bean
	public EntryFacade entryFacade()
	{
		return EntryFacade.getInstance();
	}*/

}
