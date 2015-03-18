package by.arbitrage.entity.user;

import by.arbitrage.entity.site.SiteEntity;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public class UserDTO implements User
{
	private String login;
	private List<SiteEntity> siteEntityList;


	public UserDTO()
	{
	}

	public UserDTO(String login)
	{
		this.login = login;
	}

	@Override
	public String getLogin()
	{
		return login;
	}

	@Override
	public List<SiteEntity> getSites()
	{
		return siteEntityList;
	}

	public void setLogin(String userName)
	{
		this.login = userName;
	}


	public List<SiteEntity> getSiteEntityList()
	{
		return siteEntityList;
	}

	public void setSiteEntityList(List<SiteEntity> siteEntityList)
	{
		this.siteEntityList = siteEntityList;
	}
}
