package by.arbitrage.service.order.impl;

import by.arbitrage.entity.order.Order;
import by.arbitrage.entity.order.impl.OrderEntity;
import by.arbitrage.entity.site.Site;
import by.arbitrage.entity.user.User;
import by.arbitrage.repository.OrderRepository;
import by.arbitrage.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
@Service
public class OrderServiceImpl  implements OrderService
{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Collection<Order> getAllOrdersBySite(Site site)
	{
		return null;
	}

	@Override
	public Collection<Order> getAllOrdersBySiteId(Long id)
	{
		return null;
	}

	@Override
	public Collection<Order> getAllOrdersBySiteUrl(String url)
	{
		return null;
	}

	@Override
	public Collection<Order> getOrdersByUser(User user)
	{
		return null;
	}

	@Override
	public Collection<Order> getOrdersByUserId(Long id)
	{
		return null;
	}

	@Transactional
	@Override
	public void registerOrder(Order order)
	{
		OrderEntity orderEntity = new OrderEntity(order);
		orderRepository.saveAndFlush(orderEntity);
	}
}
