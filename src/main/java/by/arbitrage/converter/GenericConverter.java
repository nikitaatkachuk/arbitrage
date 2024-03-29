package by.arbitrage.converter;

/**
 * Created by Nikita Tkachuk
 */
public interface GenericConverter<T, K>
{
	public K convertEntityToDTO(T entity);

	public T convertDTOToEntity(K dto);
}
