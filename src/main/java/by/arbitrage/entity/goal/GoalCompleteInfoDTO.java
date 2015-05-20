package by.arbitrage.entity.goal;

import by.arbitrage.entity.general.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
public class GoalCompleteInfoDTO extends AbstractDTO implements GoalCompleteInfo
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
