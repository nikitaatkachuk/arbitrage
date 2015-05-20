package by.arbitrage.entity.user;

import by.arbitrage.entity.GenericEntityImpl;
import by.arbitrage.entity.site.SiteEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "user")
public class UserEntity extends GenericEntityImpl implements User
{

	private String login;
	private String password;

	private String guid;


	private List<SiteEntity> sites;

	public UserEntity()
	{
	}

	public UserEntity(String login, String guid, String password)
	{
		this.login = login;
		this.guid = guid;
		this.password = password;
	}

	@Override
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getGuid()
	{
		return guid;
	}

	public void setGuid(String guid)
	{
		this.guid = guid;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jnd_site_user", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "site_fk"))
	public List<SiteEntity> getSites()
	{
		return sites;
	}

	public void setSites(List<SiteEntity> sites)
	{
		this.sites = sites;
	}

	public void addSite(SiteEntity site)
	{
		this.sites.add(site);
	}
}