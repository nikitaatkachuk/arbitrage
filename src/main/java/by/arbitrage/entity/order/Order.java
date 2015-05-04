package by.arbitrage.entity.order;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Nikita Tkachuk
 */
public interface Order
{
	public Long getOrderTime();

	public boolean isSecondVisit();

	public String getOrderData();
}
