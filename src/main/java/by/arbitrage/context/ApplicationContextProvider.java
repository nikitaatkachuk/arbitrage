package by.arbitrage.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Nikita Tkachuk
 */
@Scope("singleton")
public class ApplicationContextProvider implements ApplicationContextAware
{
	private static ApplicationContextProvider INSTANCE;

	private ApplicationContext context;


	private ApplicationContextProvider()
	{}

	public static ApplicationContextProvider getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new ApplicationContextProvider();
		}
		return INSTANCE;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		context = applicationContext;
	}

	public ApplicationContext getApplicationContext()
	{
		return context;
	}
}
