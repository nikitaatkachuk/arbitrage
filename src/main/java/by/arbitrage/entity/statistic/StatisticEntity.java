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

	@Column(name = "firstVisits", nullable = false)
	private Integer firstVisits;

	@Column(name = "secondVisits", nullable = false)
	private Integer secondVisits;

	@Column(name = "orderCount", nullable = false)
	private Integer orderCount;

	@OneToOne
	@JoinColumn(name = "user_fk", nullable = false)
	private UserEntity user;

	@OneToOne
	@JoinColumn(name = "site_fk", nullable = false)
	private SiteEntity siteEntity;

	@Override
	public Integer getFirstVisits()
	{
		return firstVisits;
	}

	public void setFirstVisits(Integer firstVisits)
	{
		this.firstVisits = firstVisits;
	}

	@Override
	public Integer getSecondVisits()
	{
		return secondVisits;
	}

	public void setSecondVisits(Integer secondVisits)
	{
		this.secondVisits = secondVisits;
	}

	@Override
	public Integer getOrderCount()
	{
		return orderCount;
	}

	public void setOrderCount(Integer orderCount)
	{
		this.orderCount = orderCount;
	}

	public UserEntity getUser()
	{
		return user;
	}

	public void setUser(UserEntity user)
	{
		this.user = user;
	}

	public SiteEntity getSiteEntity()
	{
		return siteEntity;
	}

	public void setSiteEntity(SiteEntity siteEntity)
	{
		this.siteEntity = siteEntity;
	}
}
