package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.converter.SiteConverter;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.ErrorMessage;
import by.arbitrage.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
//@RestController
@Controller
@RequestMapping(value = "/")
public class MainController
{
	@Autowired
	private UserContext userContext;
	@Autowired
	private SiteService siteService;
	@Autowired
	private RequestMappingHandlerAdapter adapter;

	@Autowired
	private SiteConverter siteConverter;

	@RequestMapping(method = RequestMethod.GET)
	public String login()
	{
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String indexPage()
	{
		return "index";
	}


	@ModelAttribute("currentUserSites")
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



	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage handleException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
		String error;
		for (FieldError fieldError : fieldErrors) {
			error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
			errors.add(error);
		}
		for (ObjectError objectError : globalErrors) {
			error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
			errors.add(error);
		}
		return new ErrorMessage(errors);
	}

}
