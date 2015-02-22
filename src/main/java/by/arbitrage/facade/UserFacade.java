package by.arbitrage.facade;

import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public interface UserFacade
{
	List<SiteEntity> getUserSites(UserEntity entity);

}
