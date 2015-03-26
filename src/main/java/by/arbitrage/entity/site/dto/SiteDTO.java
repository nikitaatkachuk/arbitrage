package by.arbitrage.entity.site.dto;

import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;

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

	public static SiteDTO convertFromEntity(SiteEntity entity)
	{
		return new SiteDTO(entity.getId(), entity.getUrl());
	}

	public static List<SiteDTO> convertEntityList(List<SiteEntity> entityList)
	{
		List<SiteDTO> siteDTOList = new ArrayList<>();
		for (SiteEntity entity : entityList)
		{
			siteDTOList.add(convertFromEntity(entity));
		}
		return siteDTOList;
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
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Override
	public String getScript()
	{
		return script;
	}

	public void setScript(String script)
	{
		this.script = script;
	}
}
