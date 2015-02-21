package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.entity.SiteEntity;
import by.arbitrage.service.SiteService;
import by.arbitrage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Controller
public class SiteController
{
	@Autowired
	private SiteService service;

	@Autowired
	private UserContext userContext;


	@RequestMapping(value = "/sites")
	public String get(Model model)
	{
		model.addAttribute("sites", service.getAllSites());
		return "sites";
	}

	@ModelAttribute("allSites")
	public List<SiteEntity> allSites()
	{
		return service.getAllSites();
	}

	@ModelAttribute("currentUserSites")
	public List<SiteEntity> currentUserSites()
	{
		return userContext.getCurrentUser().getSites();
	}

}
