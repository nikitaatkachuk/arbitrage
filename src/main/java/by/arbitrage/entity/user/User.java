package by.arbitrage.entity.user;

import by.arbitrage.entity.site.SiteEntity;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public interface User
{
	String getLogin();

	String getGuid();

	List<SiteEntity> getSites();
}
