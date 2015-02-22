package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


	@RequestMapping(method = RequestMethod.GET)
	@ModelAttribute("currentSite")
	public SiteEntity getSite(@RequestParam(value = "id", required = true) int id)
	{
		Long idL = Long.valueOf(id);
		//model.addAttribute("currentSite", service.findSiteById(idL));
		return service.findSiteById(idL);
	}

	@ModelAttribute("allSites")
	public List<SiteEntity> allSites()
	{
		return service.getAllSites();
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
