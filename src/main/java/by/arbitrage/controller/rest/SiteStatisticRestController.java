package by.arbitrage.controller.rest;

import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.User;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.statistic.StatisticService;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nikita Tkachuk
 */
//@RequestMapping(value = "sitestat")
@RestController
public class SiteStatisticRestController
{

	@Autowired
	private UserService userService;

	@Autowired
	private SiteService siteService;

	@Autowired
	private StatisticService statisticService;

	@RequestMapping(method = RequestMethod.POST, value = "/sitevisit")
	public void registerVisit(@RequestParam(value = "siteGuid", required = false) String siteGuid,
	                          @RequestParam(value = "userGuid", required = false) String userGuid,
	                          @RequestParam(value = "isCookie", required = false, defaultValue = "0") boolean isCookie)
	{
		try
		{
			UserEntity user = userService.findUserByGiud(userGuid);
			SiteEntity site = siteService.findSiteByGuid(siteGuid);
			if(site != null && user != null)
			{
				statisticService.registerVisit(site, user, isCookie);
			}
		}
		catch (Exception e)
		{

		}
	}

	//TODO: add implementation
	@RequestMapping(method = RequestMethod.POST, value = "/siteorder")
	public void registerOrder()
	{

	}


}
