package by.arbitrage.entity.site.dto;

import by.arbitrage.entity.general.AbstractDTO;
import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.visit.Visit;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
public class SiteDTO extends AbstractDTO implements Site
{
	private Long id;

	private String url;

	private String script;

	private String previewPath;

	private Collection<Visit> visits;



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

	@Override
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

	public Collection<Visit> getVisits()
	{
		return visits;
	}

	public void setVisits(Collection<Visit> visits)
	{
		this.visits = visits;
	}

	public String getPreviewPath()
	{
		return previewPath;
	}

	public void setPreviewPath(String previewPath)
	{
		this.previewPath = previewPath;
	}
}
