package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Controller
@RequestMapping(value = "/")
public class MainController
{
	@Autowired
	private UserContext userContext;

	@RequestMapping(method = RequestMethod.GET)
	public String login()
	{
		return "index";
	}

	@ModelAttribute("currentUserSites")
	public List<SiteDTO> currentUserSites()
	{
		return SiteDTO.convertEntityList(userContext.getCurrentUser().getSites());
	}

	//public

}
