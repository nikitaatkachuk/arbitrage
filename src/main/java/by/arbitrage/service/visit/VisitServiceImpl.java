package by.arbitrage.service.visit;

import by.arbitrage.entity.visit.Visit;
import by.arbitrage.entity.visit.VisitEntity;
import by.arbitrage.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Nikita Tkachuk
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
	@Autowired
	private VisitRepository visitRepository;

	@Override
	@Transactional
	public void saveVisit(Visit visit)
	{
		visitRepository.saveAndFlush(new VisitEntity(visit.isSecondVisit(), visit.getVisitTime(), visit.getUserGuid()));
	}
}
