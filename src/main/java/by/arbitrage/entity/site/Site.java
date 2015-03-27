package by.arbitrage.entity.site;

import by.arbitrage.entity.script.Script;

/**
 * Created by Nikita Tkachuk
 */
public interface Site
{
	Long getId();

	String getUrl();

	Script getScript();

}
