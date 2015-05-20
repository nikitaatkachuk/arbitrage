package by.arbitrage.converter;

import by.arbitrage.entity.goal.GoalCompleteInfo;
import by.arbitrage.entity.goal.GoalCompleteInfoEntity;
import by.arbitrage.entity.goal.GoalCompleteInfoDTO;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita Tkachuk
 */
public class GoalCompleteInfoConverter implements GenericConverter<GoalCompleteInfoEntity, GoalCompleteInfoDTO>
{

	@Override
	public GoalCompleteInfoDTO convertEntityToDTO(GoalCompleteInfoEntity entity)
	{
		GoalCompleteInfoDTO orderDTO = new GoalCompleteInfoDTO();
		orderDTO.setOrderTime(entity.getOrderTime());
		orderDTO.setSecondVisit(entity.isSecondVisit());
		orderDTO.setOrderData(entity.getOrderData());
		return orderDTO;
	}

	@Override
	public GoalCompleteInfoEntity convertDTOToEntity(GoalCompleteInfoDTO dto)
	{
		GoalCompleteInfoEntity orderEntity = new GoalCompleteInfoEntity();
		orderEntity.setOrderData(dto.getOrderData());
		orderEntity.setOrderTime(dto.getOrderTime());
		orderEntity.setSecondVisit(dto.isSecondVisit());
		return orderEntity;
	}

	public Collection<GoalCompleteInfoEntity> convertGenericInfosToEntitys(Collection<GoalCompleteInfo> infos)
	{
		Collection<GoalCompleteInfoEntity> result = new ArrayList<>();
		for (GoalCompleteInfo info : infos)
		{
			result.add(new GoalCompleteInfoEntity(info));
		}
		return result;
	}
}
