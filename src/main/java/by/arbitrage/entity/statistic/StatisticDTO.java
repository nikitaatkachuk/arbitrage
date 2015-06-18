package by.arbitrage.entity.statistic;

import by.arbitrage.entity.general.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
public class StatisticDTO extends AbstractDTO implements Statistic
{
	private Integer firstVisits;

	private Integer secondVisits;

	private Integer completedGoals;

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
	public Integer getCompletedGoals()
	{
		return completedGoals;
	}

	public void setCompletedGoals(Integer completedGoals)
	{
		this.completedGoals = completedGoals;
	}
}
