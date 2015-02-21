package by.arbitrage.controller;

import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.user.UserService;
import by.arbitrage.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	public @ResponseBody UserEntity get(@RequestBody UserEntity entity)
	{
		return userService.getUserByLogin(entity.getLogin());
	}

	@ModelAttribute("allUsers")
	public List<UserEntity> users()
	{
		return userService.findAll();
	}
}
