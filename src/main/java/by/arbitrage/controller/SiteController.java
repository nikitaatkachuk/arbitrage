package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.entity.site.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.statistic.Statistic;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.statistic.StatisticService;
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
@RequestMapping("site")
public class SiteController
{
	@Autowired
	private SiteService service;

	@Autowired
	private UserContext userContext;

	@Autowired
	private StatisticService statisticService;

	private SiteEntity currentSite;


	@RequestMapping(method = RequestMethod.GET)
	@ModelAttribute("currentSite")
	public SiteEntity getSite(@RequestParam(value = "id", required = true) int id)
	{
		SiteEntity currentSite = service.findUserSiteById(userContext.getCurrentUser(), (long) id );
		this.currentSite = currentSite;
		getStatistic(currentSite);
		return currentSite;
	}

	@ModelAttribute("allSites")
	public List<SiteEntity> allSites()
	{
		return service.getAllSites();
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

	public List<SiteDTO> saveSites(Principal principal, @RequestBody List<SiteDTO> sites)
	{
		return SiteDTO.convertEntityList(service.saveSites(principal.getName(), sites));
	}

}
