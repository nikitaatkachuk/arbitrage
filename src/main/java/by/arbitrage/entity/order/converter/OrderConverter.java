package by.arbitrage.entity.order.converter;

import by.arbitrage.entity.order.dto.OrderDTO;
import by.arbitrage.entity.order.impl.OrderEntity;
import by.arbitrage.utils.GenericConverter;

/**
 * Created by Nikita Tkachuk
 */
public class OrderConverter implements GenericConverter<OrderEntity, OrderDTO>
{

	@Override
	public OrderDTO convertEntityToDTO(OrderEntity entity)
	{
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderTime(entity.getOrderTime());
		orderDTO.setSecondVisit(entity.isSecondVisit());
		orderDTO.setOrderData(entity.getOrderData());
		return orderDTO;
	}

	@Override
	public OrderEntity convertDTOToEntity(OrderDTO dto)
	{
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderData(dto.getOrderData());
		orderEntity.setOrderTime(dto.getOrderTime());
		orderEntity.setSecondVisit(dto.isSecondVisit());
		return orderEntity;
	}
}
