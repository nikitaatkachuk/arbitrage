package by.arbitrage.service.statistic.impl;

import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.statistic.StatisticEntity;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.repository.StatisticRepository;
import by.arbitrage.service.statistic.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Nikita Tkachuk
 */
@Service
@Scope("singleton")
@Transactional
public class StatisticServiceImpl implements StatisticService
{
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private StatisticRepository statisticRepository;

	@Override
	public StatisticEntity findBySiteEntity(SiteEntity siteEntity, UserEntity userEntity)
	{
		return statisticRepository.findBySiteEntityAndUser(siteEntity, userEntity);
	}

	@Override
	public void registerVisit(SiteEntity site, UserEntity user, boolean isSecondVisit)
	{
		StatisticEntity statistic = findBySiteEntity(site, user);
		if(statistic != null)
		{
			if(isSecondVisit)
			{
				statistic.setSecondVisits(statistic.getSecondVisits() + 1);
			}
			else
			{
				statistic.setFirstVisits(statistic.getFirstVisits() + 1);
			}
		}
		else
		{
			statistic = new StatisticEntity();
			statistic.setSiteEntity(site);
			statistic.setUser(user);
			statistic.setSecondVisits(0);
			statistic.setOrderCount(0);
			statistic.setFirstVisits(1);
		}
		statisticRepository.save(statistic);
	}
}
