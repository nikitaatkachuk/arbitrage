package by.arbitrage.entity.site.dto;

import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.html.UserSiteForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public class SiteDTO implements Site
{
	private Long id;

	private String url;

	private String script;

	private List<UserSiteForm> forms;



	public SiteDTO()
	{
	}

	public SiteDTO(String url)
	{
		this.url = url;
	}



	public SiteDTO(Long id, String url)
	{
		this.id = id;
		this.url = url;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUrl()
	{
		if(url.startsWith("http"))
		{
			return url.replace("http://","");
		}
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getScript()
	{
		return script;
	}

	public void setScript(String script)
	{
		this.script = script;
	}

	public List<UserSiteForm> getForms()
	{
		return forms;
	}

	public void setForms(List<UserSiteForm> forms)
	{
		this.forms = forms;
	}
}
