package by.arbitrage.context;

import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Nikita Tkachuk
 */
@Scope(value = "singleton")
public class UserContext
{
	@Autowired
	private UserService service;

	public UserContext()
	{
	}

	public String getCurrentUserName()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public UserEntity getCurrentUser()
	{
		return service.findUserByLogin(getCurrentUserName());
	}


}
