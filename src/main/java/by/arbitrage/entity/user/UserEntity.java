package by.arbitrage.entity.user;

import by.arbitrage.entity.SiteEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "user")
public class UserEntity
{
	@Id
	@GeneratedValue
	private Long id;

	private String login;
	private String password;

	@Column(name = "guid")
	private String guid;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jnd_site_user", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "site_fk"))
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

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

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

	public List<SiteEntity> getSites()
	{
		return sites;
	}

	public void setSites(List<SiteEntity> sites)
	{
		this.sites = sites;
	}
}
