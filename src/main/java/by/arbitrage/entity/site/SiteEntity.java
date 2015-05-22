package by.arbitrage.entity.site;

import by.arbitrage.entity.GenericEntityImpl;
import by.arbitrage.entity.goal.Goal;
import by.arbitrage.entity.goal.GoalEntity;
import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.entity.visit.Visit;
import by.arbitrage.entity.visit.VisitEntity;
import by.arbitrage.html.render.PreviewBuilder;

import javax.persistence.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "site")
public class SiteEntity extends GenericEntityImpl implements Site
{
	private String url;

	private String guid;

	private Script script;

	private Set<UserEntity> users;

	private String previewPath;

	private Collection<Goal> goals;

	private Set<Visit> visits;

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

	@ManyToMany(mappedBy = "sites", fetch = FetchType.EAGER)
	public Set<UserEntity> getUsers()
	{
		return users;
	}

	public void setUsers(Set<UserEntity> users)
	{
		this.users = users;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "script_fk")
	public Script getScript()
	{
		return script;
	}

	public void setScript(Script script)
	{
		this.script = script;
	}

	@OneToMany(fetch = FetchType.EAGER, targetEntity = VisitEntity.class, orphanRemoval = true)
	@JoinColumn(name = "site_fk", nullable = false, unique = true)
	public Set<Visit> getVisits()
	{
		return visits;
	}

	public void setVisits(Set<Visit> visits)
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

	@PrePersist
	private void updateInformation() throws IOException
	{
		if (previewPath == null || "".equals(previewPath))
		{
			previewPath = PreviewBuilder.buildPreview(url, guid);
		}
	}

	@OneToMany(mappedBy = "site",cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = GoalEntity.class, orphanRemoval = true)
	public Collection<Goal> getGoals()
	{
		return goals;
	}

	public void setGoals(Collection<Goal> goals)
	{
		this.goals = goals;
	}
}
