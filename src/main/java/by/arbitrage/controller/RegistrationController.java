package by.arbitrage.controller;

import by.arbitrage.entity.user.NewUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nikita Tkachuk
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController
{
	@RequestMapping(method = RequestMethod.GET)
	public String registrationPage(Model model)
	{
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerUser(NewUserDTO newUserDTO)
	{
		return "index";
	}
}
