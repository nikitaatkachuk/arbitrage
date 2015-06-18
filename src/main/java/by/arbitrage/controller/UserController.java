package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.converter.SiteConverter;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nikita Tkachuk
 */
@RestController
@RequestMapping("/user")
public class UserController
{
	private static final  Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserContext userContext;
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteConverter siteConverter;


	public @ResponseBody UserEntity get(@RequestBody UserEntity entity)
	{
		return userService.findUserByLogin(entity.getLogin());
	}


	@RequestMapping( method = RequestMethod.POST, value = "/addSite")
	public @ResponseBody
	SiteDTO addSiteForCurrentUser(@RequestParam(value = "url") String newSiteURL)
	{
		if(newSiteURL != null)
		{
			SiteDTO dto = new SiteDTO(newSiteURL);
			UserEntity currentUser = userContext.getCurrentUser();
			SiteEntity site = siteService.saveSiteByDTO(dto, currentUser);
			currentUser.getSites().add(site);
			userService.save(currentUser);
			return siteConverter.convertEntityToDTO(site);
		}
		else
		{
			return null;
		}
	}

	public void removeSite()
	{

	}
}
