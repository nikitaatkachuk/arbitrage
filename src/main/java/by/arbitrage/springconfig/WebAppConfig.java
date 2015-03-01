package by.arbitrage.springconfig;

import by.arbitrage.context.UserContext;
import by.arbitrage.service.user.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
	/*@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter()
	{
		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
		List<HttpMessageConverter<?>> list = new ArrayList<>(1);
		list.add(jackson2HttpMessageConverter());
		adapter.setMessageConverters(list);
		adapter.setRequireSession(false);
		adapter.setSupportedMethods("POST", "GET", "PUT");
		return adapter;
	}

	@Bean
	public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter()
	{
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		return converter;
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
