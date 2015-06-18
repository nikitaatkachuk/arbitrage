package by.arbitrage.controller.rest;

import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.entity.visit.VisitEntity;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.statistic.StatisticService;
import by.arbitrage.service.user.UserService;
import by.arbitrage.service.visit.VisitService;
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
	private VisitService visitService;

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
				site.getVisits().add(new VisitEntity(isCookie, System.currentTimeMillis(), userGuid));
				statisticService.registerVisitInStatistic(site, user, isCookie);
				siteService.updateSite(site);
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
