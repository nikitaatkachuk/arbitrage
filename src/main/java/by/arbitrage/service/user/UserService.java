package by.arbitrage.service.user;

import by.arbitrage.entity.user.UserEntity;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public interface UserService
{
	String BEAN_NAME = "UserService";

	UserEntity save(UserEntity user);

	List<UserEntity> findAll();

	UserEntity getUserByLogin(String login);
}
