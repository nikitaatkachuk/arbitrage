package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.entity.site.dto.NewSiteDTO;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.statistic.Statistic;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.statistic.StatisticService;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Controller
//@RequestMapping("/site")
public class SiteController
{
	@Autowired
	private SiteService siteService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserContext userContext;

	@Autowired
	private StatisticService statisticService;



	@RequestMapping(method = RequestMethod.GET, value = "/site/{id}")
	public String getSite(Model model , @PathVariable String id)
	{
		SiteEntity currentSite = siteService.findUserSiteById(userContext.getCurrentUser(), Long.valueOf(id));
		model.addAttribute("currentSite", currentSite);
		getStatistic(currentSite);
		return "site";
	}

	@ModelAttribute("allSites")
	public List<SiteEntity> allSites()
	{
		return siteService.getAllSites();
	}

	@ModelAttribute("statistic")
	public Statistic getStatistic(SiteEntity site)
	{
		if(site != null)
		{
			return statisticService.findBySiteEntity(site, userContext.getCurrentUser());
		}
		return null;
	}



	//@RequestMapping(method = RequestMethod.GET, value = "site/")
	public String generateScript()
	{
		return null;
	}

	public List<SiteDTO> currentUserSites()
	{
		return SiteDTO.convertEntityList(userContext.getCurrentUser().getSites());
	}

	public List<SiteDTO> saveSites(Principal principal, @RequestBody List<NewSiteDTO> sites)
	{
		return SiteDTO.convertEntityList(siteService.saveSites(principal.getName(), sites));
	}

}
