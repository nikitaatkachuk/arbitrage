package by.arbitrage.entity.visit;

import by.arbitrage.entity.GenericEntity;

/**
 * Created by Nikita Tkachuk
 */
public interface Visit extends GenericEntity
{
	boolean isSecondVisit();

	Long getVisitTime();

	String getUserGuid();
}
