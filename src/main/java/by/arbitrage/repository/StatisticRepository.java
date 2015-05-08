package by.arbitrage.repository;

import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.statistic.Statistic;
import by.arbitrage.entity.statistic.StatisticEntity;
import by.arbitrage.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nikita Tkachuk
 */
public interface StatisticRepository extends JpaRepository<StatisticEntity, Long>
{
	StatisticEntity findBySiteEntityAndUser(SiteEntity site, UserEntity userEntity);

	StatisticEntity findByIdentity(Long id);

	//void updateStat
}
