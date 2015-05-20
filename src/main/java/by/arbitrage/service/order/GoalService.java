package by.arbitrage.service.order;

import by.arbitrage.entity.goal.Goal;
import by.arbitrage.entity.goal.GoalCompleteInfo;

import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
public interface GoalService
{
	public Goal createGoal(Goal goal);

	public void completeGoal(GoalCompleteInfo completeInfo);

	public void deleteGoal(Goal goal);

	public Goal updateGoal();

	public Collection<Goal> getGoalsBySiteId(Long id);
}
