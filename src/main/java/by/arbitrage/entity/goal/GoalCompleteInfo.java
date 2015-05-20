package by.arbitrage.entity.goal;

import by.arbitrage.entity.GenericEntity;

/**
 * Created by Nikita Tkachuk
 */
public interface GoalCompleteInfo extends GenericEntity
{
	public Long getOrderTime();

	public boolean isSecondVisit();

	public String getOrderData();
}
