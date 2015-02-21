package by.arbitrage.facade;

import by.arbitrage.context.ApplicationContextProvider;
import by.arbitrage.springconfig.WebAppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by Nikita Tkachuk
 */
@Scope("singleton")
public class EntryFacade
{
	private static EntryFacade ENTRY_FACADE;

	private ApplicationContext context;

	private EntryFacade()
	{
		ApplicationContextProvider contextProvider = ApplicationContextProvider.getInstance();
		this.context = contextProvider.getApplicationContext();
	}

	public static EntryFacade getInstance()
	{
		if(ENTRY_FACADE == null)
		{
			ENTRY_FACADE = new EntryFacade();
		}
		return ENTRY_FACADE;
	}

	@SuppressWarnings({"unchecked"})
	public <T> T lookupBean(String beanName)
	{
		return (T) context.getBean(beanName);
	}


}
