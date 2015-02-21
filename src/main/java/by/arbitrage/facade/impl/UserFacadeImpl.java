package by.arbitrage.facade.impl;

import by.arbitrage.entity.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.facade.UserFacade;
import by.arbitrage.service.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Component
public class UserFacadeImpl implements UserFacade
{
	private UserService userService;

	@Override
	public List<SiteEntity> getUserSites(UserEntity entity)
	{
		return null;
	}
}
