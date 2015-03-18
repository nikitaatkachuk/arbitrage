package by.arbitrage.entity.site;

import by.arbitrage.entity.user.UserEntity;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "site")
public class SiteEntity implements Site
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String url;

	private String guid;

	@ManyToMany(mappedBy = "sites", fetch = FetchType.EAGER)
	private List<UserEntity> users;

	public SiteEntity()
	{
	}

	public SiteEntity(String url)
	{
		this.url = url;
	}

	@Override
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
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getGuid()
	{
		return guid;
	}

	public void setGuid(String guid)
	{
		this.guid = guid;
	}

	@Override
	public List<UserEntity> getUsers()
	{
		return users;
	}

	public void setUsers(List<UserEntity> users)
	{
		this.users = users;
	}
}
