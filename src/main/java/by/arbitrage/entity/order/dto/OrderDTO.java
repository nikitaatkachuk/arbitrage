package by.arbitrage.entity.order.dto;

import by.arbitrage.entity.order.Order;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
public class OrderDTO implements Order
{
	private Long orderTime;

	private String orderData;

	private Boolean secondVisit;

	public void setOrderTime(Long orderTime)
	{
		this.orderTime = orderTime;
	}

	public void setOrderData(String orderData)
	{
		this.orderData = orderData;
	}

	public void setSecondVisit(boolean secondVisit)
	{
		this.secondVisit = secondVisit;
	}

	@Override
	public Long getOrderTime()
	{
		return orderTime;
	}

	@Override
	public boolean isSecondVisit()
	{
		return secondVisit;
	}

	@Override
	public String getOrderData()
	{
		return orderData;
	}
}
