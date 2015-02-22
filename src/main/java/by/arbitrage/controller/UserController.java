package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.user.UserService;
import by.arbitrage.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	@Autowired
	private UserContext userContext;

	public @ResponseBody UserEntity get(@RequestBody UserEntity entity)
	{
		return userService.getUserByLogin(entity.getLogin());
	}


	//@ModelAttribute("currentUserSites")
	@RequestMapping(value = "/currentUsers", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<SiteEntity> currentUserSites()
	{
		return userContext.getCurrentUser().getSites();
	}

	@ModelAttribute("allUsers")
	public List<UserEntity> users()
	{
		return userService.findAll();
	}
}
