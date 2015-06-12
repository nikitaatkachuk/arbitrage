package by.arbitrage.controller;

import by.arbitrage.entity.statistic.Statistic;
import by.arbitrage.entity.statistic.StatisticDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Nikita Tkachuk
 */
@Controller
public class DetailStatisticController
{
	@RequestMapping(method = RequestMethod.GET, value = "/site/{id}/statistic")
	public String getStatisticPage(Model model)
	{
		return "statistic";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/site/{siteId}/statistic/byusername")
	public @ResponseBody
	StatisticDTO getByUserName(@PathVariable String siteId, String name)
	{
		StatisticDTO statisticDTO = new StatisticDTO();
		statisticDTO.setSecondVisits(17);
		statisticDTO.setFirstVisits(25);
		statisticDTO.setCompletedGoals(9);
		return statisticDTO;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/site/{siteId}/statistic/bygroupname")
	public @ResponseBody StatisticDTO getByGroupName(@PathVariable String siteId, String name)
	{
		StatisticDTO statisticDTO = new StatisticDTO();
		statisticDTO.setSecondVisits(2);
		statisticDTO.setFirstVisits(6);
		statisticDTO.setCompletedGoals(4);
		return statisticDTO;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/site/{siteId}/statistic/bysite")
	public @ResponseBody StatisticDTO getBySite(@PathVariable String siteId)
	{
		StatisticDTO statisticDTO = new StatisticDTO();
		statisticDTO.setSecondVisits(5);
		statisticDTO.setFirstVisits(10);
		statisticDTO.setCompletedGoals(2);
		return statisticDTO;
	}
}
