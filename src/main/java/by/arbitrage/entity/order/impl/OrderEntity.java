package by.arbitrage.entity.order.impl;

import by.arbitrage.entity.order.Order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "order")
public class OrderEntity implements Order
{
	@Id
	private Long id;

	private Long orderTime;

	private String orderData;

	private Boolean secondVisit;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Override
	public Long getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(Long orderTime)
	{
		this.orderTime = orderTime;
	}

	@Override
	public String getOrderData()
	{
		return orderData;
	}

	public void setOrderData(String orderData)
	{
		this.orderData = orderData;
	}

	public Boolean isSecondVisit()
	{
		return secondVisit;
	}

	public void setSecondVisit(Boolean secondVisit)
	{
		this.secondVisit = secondVisit;
	}
}
