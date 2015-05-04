package by.arbitrage.service.order;

import by.arbitrage.entity.order.Order;
import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.user.User;

import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
public interface OrderService
{
	public Collection<Order> getAllOrdersBySite(Site site);

	public Collection<Order> getAllOrdersBySiteId(Long id);

	public Collection<Order> getAllOrdersBySiteUrl(String url);

	public Collection<Order> getOrdersByUser(User user);

	public Collection<Order> getOrdersByUserId(Long id);

	public void registerOrder(Order order);
}
