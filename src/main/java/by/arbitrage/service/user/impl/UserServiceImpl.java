package by.arbitrage.service.user.impl;

import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.repository.UserRepository;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Service
@Transactional
@Scope(value = "singleton")
public class UserServiceImpl implements UserService
{
	@Qualifier("userRepository")
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity create(UserEntity user)
	{
		return userRepository.saveAndFlush(user);
	}

	@Override
	public List<UserEntity> findAll()
	{
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserByLogin(String login)
	{
		return userRepository.findUserByLogin(login);
	}



}
