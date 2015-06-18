package by.arbitrage.entity.statistic;

import by.arbitrage.entity.GenericEntityImpl;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "statistic")
public class StatisticEntity extends GenericEntityImpl implements Statistic
{

	private Integer firstVisits;

	private Integer secondVisits;

	private Integer completedGoals;

	private UserEntity user;

	private SiteEntity siteEntity;

	@Override
	@Column(name = "firstVisits", nullable = false)
	public Integer getFirstVisits()
	{
		return firstVisits;
	}

	public void setFirstVisits(Integer firstVisits)
	{
		this.firstVisits = firstVisits;
	}

	@Override
	@Column(name = "secondVisits", nullable = false)
	public Integer getSecondVisits()
	{
		return secondVisits;
	}

	public void setSecondVisits(Integer secondVisits)
	{
		this.secondVisits = secondVisits;
	}

	@Override
	@Column(name = "orderCount", nullable = false)
	public Integer getCompletedGoals()
	{
		return completedGoals;
	}

	public void setCompletedGoals(Integer completedGoals)
	{
		this.completedGoals = completedGoals;
	}

	@OneToOne
	@JoinColumn(name = "user_fk", nullable = false)
	public UserEntity getUser()
	{
		return user;
	}

	public void setUser(UserEntity user)
	{
		this.user = user;
	}

	@OneToOne
	@JoinColumn(name = "site_fk", nullable = false)
	public SiteEntity getSiteEntity()
	{
		return siteEntity;
	}

	public void setSiteEntity(SiteEntity siteEntity)
	{
		this.siteEntity = siteEntity;
	}
}
