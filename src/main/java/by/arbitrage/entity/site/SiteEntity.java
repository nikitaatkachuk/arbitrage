package by.arbitrage.entity.site;

import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.html.UserSiteForm;
import by.arbitrage.html.parser.FormParser;

import javax.persistence.*;
import java.io.IOException;
import java.util.Collection;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "script_fk")
	private Script script;

	@ManyToMany(mappedBy = "sites", fetch = FetchType.EAGER)
	private List<UserEntity> users;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "site_fk", nullable = false)
	private Collection<UserSiteForm> siteForms;

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

	public List<UserEntity> getUsers()
	{
		return users;
	}

	public void setUsers(List<UserEntity> users)
	{
		this.users = users;
	}

	public Script getScript()
	{
		return script;
	}

	public void setScript(Script script)
	{
		this.script = script;
	}

	public Collection<UserSiteForm> getSiteForms()
	{
		return siteForms;
	}

	public void setSiteForms(Collection<UserSiteForm> siteForms)
	{
		this.siteForms = siteForms;
	}

	@PrePersist
	private void updateForms() throws IOException
	{
		if(siteForms.isEmpty())
		{
			siteForms = FormParser.getSiteFormsByUrl(url);
		}
	}
}
