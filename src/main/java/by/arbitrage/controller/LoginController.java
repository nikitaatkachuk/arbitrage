package by.arbitrage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nikita Tkachuk
 */
@Controller
@RequestMapping("/login")
public class LoginController
{

	@RequestMapping(method = RequestMethod.GET)
	public String loginPage(Model model){
		return "login";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

}
