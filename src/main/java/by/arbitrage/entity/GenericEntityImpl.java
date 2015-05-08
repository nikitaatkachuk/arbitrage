package by.arbitrage.entity;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@MappedSuperclass
public abstract class GenericEntityImpl implements GenericEntity
{
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long identity;

	public Long getIdentity()
	{
		return identity;
	}

	protected void setIdentity()
	{

	}
}
