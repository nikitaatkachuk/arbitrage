package by.arbitrage.repository;

import by.arbitrage.entity.goal.GoalCompleteInfoEntity;
import by.arbitrage.entity.goal.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikita Tkachuk
 */
public interface GoalRepository extends JpaRepository<GoalEntity, Long>
{
	//public void
}
