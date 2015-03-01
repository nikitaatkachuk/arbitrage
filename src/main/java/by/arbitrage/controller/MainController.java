package by.arbitrage.controller;

import by.arbitrage.context.UserContext;
import by.arbitrage.dto.NewSiteDTO;
import by.arbitrage.dto.SiteDTO;
import by.arbitrage.entity.ErrorMessage;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.service.SiteService;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.io.File;
import java.io.IOException;
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
