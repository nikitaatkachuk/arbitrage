package by.arbitrage.entity.site;

import by.arbitrage.entity.user.UserEntity;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public interface Site
{
	Long getId();

	String getUrl();

	List<UserEntity> getUsers();

}
