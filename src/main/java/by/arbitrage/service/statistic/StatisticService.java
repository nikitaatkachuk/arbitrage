package by.arbitrage.service.statistic;

import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.statistic.StatisticEntity;
import by.arbitrage.entity.user.UserEntity;

/**
 * Created by Nikita Tkachuk
 */
public interface StatisticService
{
	public StatisticEntity findBySiteEntity(SiteEntity siteEntity, UserEntity userEntity);

	public void registerVisitInStatistic(SiteEntity site, UserEntity user, boolean isSecondVisit);
}
