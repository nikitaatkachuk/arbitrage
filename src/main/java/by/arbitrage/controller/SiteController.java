package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.converter.SiteConverter;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.statistic.Statistic;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.statistic.StatisticService;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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
	private SiteConverter siteConverter;

	@Autowired
	private UserContext userContext;

	@Autowired
	private StatisticService statisticService;



	@RequestMapping(method = RequestMethod.GET, value = "/site/{id}")
	public String getSite(Model model , @PathVariable String id)
	{
		SiteEntity currentSite = siteService.findUserSiteById(userContext.getCurrentUser(), Long.valueOf(id));
		SiteDTO dto = siteConverter.convertEntityToDTO(currentSite);
		model.addAttribute("currentSite", dto);
		getStatistic(currentSite);

		return "site";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/site/{id}")
	public void deleteSite(@PathVariable String id)
	{

	}

	@ModelAttribute("allSites")
	public List<SiteEntity> allSites()
	{
		return siteService.getAllSites();
	}

	@ModelAttribute("statistic")
	private Statistic getStatistic(SiteEntity site)
	{
		if(site != null)
		{
			return statisticService.findBySiteEntity(site, userContext.getCurrentUser());
		}
		return null;
	}



	@RequestMapping(method = RequestMethod.POST, value = "site/generateScript")
	public String generateScript()
	{
		return null;
	}

	public List<SiteDTO> currentUserSites()
	{
		List<SiteDTO> result = new ArrayList<>();
		List<SiteEntity> sites =  userContext.getCurrentUser().getSites();
		for(SiteEntity siteEntity : sites)
		{
			result.add(siteConverter.convertEntityToDTO(siteEntity ));
		}
		return result;
	}

/*	public List<SiteDTO> saveSites(Principal principal, @RequestBody List<NewSiteDTO> sites)
	{
		return SiteDTO.convertEntityList(siteService.saveSitesByDtoList(principal.getName(), sites));
	}*/

}
