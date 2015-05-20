package by.arbitrage.controller;

import by.arbitrage.converter.GoalCompleteInfoConverter;
import by.arbitrage.entity.goal.GoalCompleteInfoDTO;
import by.arbitrage.entity.goal.GoalDTO;
import by.arbitrage.entity.goal.GoalEntity;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.order.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nikita Tkachuk
 */
@Controller
public class GoalController
{
	@Autowired
	private GoalService goalService;

	@Autowired
	private SiteService siteService;

	@RequestMapping(method = RequestMethod.POST, value = "site/{id}/goal/register")
	public void registerOrder(@PathVariable String id, GoalDTO goal)
	{
		SiteEntity site = siteService.findSiteById(Long.valueOf(id));
		GoalEntity goalEntity = new GoalEntity(goal);
		site.getGoals().add(goalEntity);
		siteService.updateSite(site);
	}

	@RequestMapping(method = RequestMethod.POST, value = "goal/complete")
	public void completeGoal(GoalCompleteInfoDTO completeInfoDTO)
	{
		GoalCompleteInfoConverter completeInfoConverter = new GoalCompleteInfoConverter();
		goalService.completeGoal(completeInfoConverter.convertDTOToEntity(completeInfoDTO));
	}
}
