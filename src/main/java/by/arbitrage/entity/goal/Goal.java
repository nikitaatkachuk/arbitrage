package by.arbitrage.entity.goal;

import by.arbitrage.entity.GenericEntity;

import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
public interface Goal extends GenericEntity
{
	public String getPageUrlPattern();

	public boolean isEndPoint();

	public Collection<GoalCompleteInfo> getCompletedGoals();

}
