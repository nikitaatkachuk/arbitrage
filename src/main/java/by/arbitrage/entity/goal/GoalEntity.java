package by.arbitrage.entity.goal;

import by.arbitrage.converter.GoalCompleteInfoConverter;
import by.arbitrage.entity.GenericEntityImpl;
import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.html.UserSiteForm;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "goal")
public class GoalEntity extends GenericEntityImpl implements Goal
{

	private String pageUrlPattern;

	private boolean endPoint;

	private Collection<GoalCompleteInfo> completedGoals;

	private Collection<UserSiteForm> siteForms;

	private Site site;

	public GoalEntity()
	{
	}

	public GoalEntity(Goal goal)
	{
		this(goal.getPageUrlPattern(), goal.isEndPoint(), goal.getCompletedGoals());
	}


	public GoalEntity(String pageUrlPattern, boolean endPoint, Collection<GoalCompleteInfo> completedGoals)
	{
		this.pageUrlPattern = pageUrlPattern;
		this.endPoint = endPoint;
		this.completedGoals = completedGoals;
	}

	@Override
	@Column(name = "page_url_pattern")
	public String getPageUrlPattern()
	{
		return pageUrlPattern;
	}

	public void setPageUrlPattern(String pageUrlPattern)
	{
		this.pageUrlPattern = pageUrlPattern;
	}

	@Override
	@Column(name = "is_end_point")
	public boolean isEndPoint()
	{
		return endPoint;
	}

	public void setEndPoint(boolean endPoint)
	{
		this.endPoint = endPoint;
	}

	@Override
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = GoalCompleteInfoEntity.class)
	@JoinColumn(name = "goal_fk", nullable = false)
	public Collection<GoalCompleteInfo> getCompletedGoals()
	{
		return completedGoals;
	}

	public void setCompletedGoals(Collection<GoalCompleteInfo> completedGoals)
	{
		this.completedGoals = completedGoals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "goal_fk", nullable = false)
	public Collection<UserSiteForm> getSiteForms()
	{
		return siteForms;
	}

	public void setSiteForms(Collection<UserSiteForm> siteForms)
	{
		this.siteForms = siteForms;
	}

	@ManyToOne(targetEntity = SiteEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "site_fk")
	public Site getSite()
	{
		return site;
	}

	public void setSite(Site site)
	{
		this.site = site;
	}
}
