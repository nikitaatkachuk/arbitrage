package by.arbitrage.controller;

import by.arbitrage.entity.order.dto.OrderDTO;
import by.arbitrage.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nikita Tkachuk
 */
@Controller
public class OrderController
{
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, value = "order/register")
	public void registerOrder(OrderDTO order)
	{
		orderService.registerOrder(order);
	}
}
