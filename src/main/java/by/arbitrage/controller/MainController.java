package by.arbitrage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nikita Tkachuk
 */
@Controller
@RequestMapping(value = "/")
public class MainController
{
	@RequestMapping(method = RequestMethod.GET)
	public String login()
	{
		return "index";
	}

}
