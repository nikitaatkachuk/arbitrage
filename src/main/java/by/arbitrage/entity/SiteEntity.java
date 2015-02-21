package by.arbitrage.entity;

import by.arbitrage.entity.user.UserEntity;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "site")
public class SiteEntity
{
	@Id
	@GeneratedValue
	private Long id;

	private String url;

	private String guid;

	@ManyToMany(mappedBy = "sites", fetch = FetchType.LAZY)
	private List<UserEntity> users;

	public SiteEntity()
	{
	}

	public SiteEntity(String url)
	{
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

	public List<UserEntity> getUsers()
	{
		return users;
	}

	public void setUsers(List<UserEntity> users)
	{
		this.users = users;
	}
}
