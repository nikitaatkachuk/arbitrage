package by.arbitrage.service.order.impl;

import by.arbitrage.entity.goal.Goal;
import by.arbitrage.entity.goal.GoalCompleteInfo;
import by.arbitrage.entity.goal.GoalEntity;
import by.arbitrage.repository.GoalRepository;
import by.arbitrage.service.order.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
@Service
public class GoalServiceImpl implements GoalService
{
	@Autowired
	private GoalRepository goalRepository;


	@Transactional
	@Override
	public Goal createGoal(Goal goal)
	{
		GoalEntity goalEntity = (GoalEntity)goal;
		goalRepository.saveAndFlush(goalEntity);
		return goalEntity;
	}

	@Override
	public void completeGoal(GoalCompleteInfo completeInfo)
	{

	}

	@Override
	@Transactional
	public void deleteGoal(Goal goal)
	{
		goalRepository.delete((GoalEntity)goal);
	}

	@Override
	public Goal updateGoal()
	{
		return null;
	}

	@Override
	public Collection<Goal> getGoalsBySiteId(Long id)
	{
		return null;
	}
}
