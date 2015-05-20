package by.arbitrage.entity.goal;

import by.arbitrage.entity.general.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
public class GoalDTO extends AbstractDTO implements Goal
{
	private String pageUrlPattern;
	private boolean endPoint;
	private Collection<GoalCompleteInfo> completedGoals;

	@Override
	public String getPageUrlPattern()
	{
		return pageUrlPattern;
	}

	public void setPageUrlPattern(String pageUrlPattern)
	{
		this.pageUrlPattern = pageUrlPattern;
	}

	@Override
	public boolean isEndPoint()
	{
		return endPoint;
	}

	public void setEndPoint(boolean endPoint)
	{
		this.endPoint = endPoint;
	}

	@Override
	public Collection<GoalCompleteInfo> getCompletedGoals()
	{
		return completedGoals;
	}

	public void setCompletedGoals(Collection<GoalCompleteInfo> completedGoals)
	{
		this.completedGoals = completedGoals;
	}
}
