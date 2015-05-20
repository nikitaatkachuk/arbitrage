package by.arbitrage.entity;

import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@MappedSuperclass
//@Access(AccessType.PROPERTY)
public abstract class GenericEntityImpl implements GenericEntity
{
	private Long identity;

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, scale = 0, unique = true, updatable = true)
	public Long getIdentity()
	{
		return identity;
	}

	protected void setIdentity(Long identity)
	{
		this.identity = identity;
	}

	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null)
		{
			return false;
		}
		Class c1 = ( o instanceof HibernateProxy) ? ( (HibernateProxy) o ).writeReplace().getClass() : o.getClass();
		if (c1 != this.getClass())
		{
			return false;
		}
		final GenericEntityImpl that = (GenericEntityImpl) o;
		return getIdentity() != null && getIdentity().equals(that.getIdentity());
	}

	public int hashCode()
	{
		return ( getIdentity() != null ? getIdentity().hashCode() : super.hashCode() );
	}

	public boolean isInstanceOf(Class entityClass)
	{
		Class thisClass = ( this instanceof HibernateProxy ) ? ( (HibernateProxy) this ).writeReplace().getClass() : getClass();
		return entityClass.isAssignableFrom(thisClass);
	}
}
