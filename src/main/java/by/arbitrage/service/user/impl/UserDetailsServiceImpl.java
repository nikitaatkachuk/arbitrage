package by.arbitrage.service.user.impl;

import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.entity.user.UserRole;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Tkachuk
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		UserEntity user = service.findUserByLogin(username);
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(UserRole.MANAGER.name()));
		return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),roles);
	}
}
