package by.arbitrage.entity.network;

import by.arbitrage.entity.site.Site;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public interface Network
{
	public String getName();
	public List<Site> getSites();
}
