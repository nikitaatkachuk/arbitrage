package by.arbitrage.entity.goal;

import by.arbitrage.entity.GenericEntityImpl;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "completed_goals")
public class GoalCompleteInfoEntity extends GenericEntityImpl implements GoalCompleteInfo
{

	private Long orderTime;

	private String orderData;

	private boolean secondVisit;

	public GoalCompleteInfoEntity()
	{
	}

	public GoalCompleteInfoEntity(GoalCompleteInfo goalCompleteInfo)
	{
		this(goalCompleteInfo.getOrderTime(), goalCompleteInfo.getOrderData(), goalCompleteInfo.isSecondVisit());
	}

	public GoalCompleteInfoEntity(Long orderTime, String orderData, Boolean secondVisit)
	{
		this.orderTime = orderTime;
		this.orderData = orderData;
		this.secondVisit = secondVisit;
	}

	@Override
	@Column(name = "order_time")
	public Long getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(Long orderTime)
	{
		this.orderTime = orderTime;
	}

	@Override
	@Column(name = "order_data")
	public String getOrderData()
	{
		return orderData;
	}

	public void setOrderData(String orderData)
	{
		this.orderData = orderData;
	}

	@Column(name = "second_visit")
	public boolean isSecondVisit()
	{
		return secondVisit;
	}

	public void setSecondVisit(boolean secondVisit)
	{
		this.secondVisit = secondVisit;
	}
}
