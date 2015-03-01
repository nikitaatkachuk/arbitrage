package by.arbitrage.entity.user;

import by.arbitrage.entity.site.SiteEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "user")
public class UserEntity implements User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;
	private String password;

	@Column(name = "guid")
	private String guid;


	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
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

	@Override
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	@Override
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

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof UserEntity)) return false;

		UserEntity that = (UserEntity) o;

		if (!guid.equals(that.guid)) return false;
		if (!id.equals(that.id)) return false;
		if (!login.equals(that.login)) return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = id.hashCode();
		result = 31 * result + login.hashCode();
		result = 31 * result + guid.hashCode();
		return result;
	}
}
