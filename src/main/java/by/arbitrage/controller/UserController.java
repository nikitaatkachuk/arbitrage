package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.SiteService;
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
@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;
	@Autowired
	private UserContext userContext;
	@Autowired
	private SiteService siteService;


	public @ResponseBody UserEntity get(@RequestBody UserEntity entity)
	{
		return userService.getUserByLogin(entity.getLogin());
	}


	@RequestMapping( method = RequestMethod.GET, value = "/addSite")
	public @ResponseBody
	SiteDTO addSite(@RequestParam(value = "url") String newSiteURL)
	{
		if(newSiteURL != null)
		{
			SiteDTO dto = new SiteDTO(newSiteURL);
			SiteEntity siteEntity = siteService.convertDTOtoEntity(userContext.getCurrentUserName(), dto);
			UserEntity currentUser = userContext.getCurrentUser();
			currentUser.addSite(siteEntity);
			userService.save(currentUser);
			return SiteDTO.convertFromEntity(siteEntity);
		}
		else
		{
			return null;
		}
	}
}
