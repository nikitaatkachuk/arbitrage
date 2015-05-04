package by.arbitrage.entity.order.impl;

import by.arbitrage.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "site_orders")
public class OrderEntity implements Order
{
	//@Column(name = "ID")
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "order_time")
	private Long orderTime;

	@Column(name = "order_data")
	private String orderData;

	@Column(name = "second_visit")
	private boolean secondVisit;

	public OrderEntity()
	{
	}

	public OrderEntity(Order order)
	{
		this(order.getOrderTime(), order.getOrderData(), order.isSecondVisit());
	}

	public OrderEntity(Long orderTime, String orderData, Boolean secondVisit)
	{
		this.orderTime = orderTime;
		this.orderData = orderData;
		this.secondVisit = secondVisit;
	}

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

	public boolean isSecondVisit()
	{
		return secondVisit;
	}

	public void setSecondVisit(boolean secondVisit)
	{
		this.secondVisit = secondVisit;
	}
}
