package by.arbitrage.repository;

import by.arbitrage.entity.order.impl.OrderEntity;
import by.arbitrage.entity.site.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikita Tkachuk
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long>
{
	//public void
}
