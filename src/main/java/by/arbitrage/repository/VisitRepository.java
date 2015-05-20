package by.arbitrage.repository;

import by.arbitrage.entity.visit.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikita Tkachuk
 */
public interface VisitRepository extends JpaRepository<VisitEntity, Long>
{

}
