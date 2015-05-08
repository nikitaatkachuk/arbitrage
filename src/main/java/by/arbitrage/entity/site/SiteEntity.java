package by.arbitrage.entity.site;

import by.arbitrage.entity.GenericEntityImpl;
import by.arbitrage.entity.order.impl.OrderEntity;
import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.html.UserSiteForm;
import by.arbitrage.html.parser.FormParser;
import by.arbitrage.html.render.PreviewBuilder;

import javax.persistence.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "site")
public class SiteEntity extends GenericEntityImpl implements Site
{
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

	private String previewPath;

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "site_fk", nullable = false)
	private Collection<OrderEntity> orders;*/

	public SiteEntity()
	{
	}

	public SiteEntity(String url)
	{
		this.url = url;
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


	public String getPreviewPath()
	{
		return previewPath;
	}
	public void setPreviewPath(String previewPath)
	{
		this.previewPath = previewPath;
	}

	@PrePersist
	private void updateInformation() throws IOException
	{
		if(siteForms.isEmpty())
		{
			//siteForms = FormParser.getSiteFormsByUrl(url);
		}
		if(previewPath == null || "".equals(previewPath))
		{
			previewPath = PreviewBuilder.buildPreview(url, guid);
		}
	}

}
