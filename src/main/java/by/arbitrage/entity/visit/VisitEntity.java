package by.arbitrage.entity.visit;

import by.arbitrage.entity.GenericEntityImpl;
import by.arbitrage.entity.site.SiteEntity;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "visit")
public class VisitEntity extends GenericEntityImpl  implements Visit
{
	private boolean secondVisit;

	private Long visitTime;


	public VisitEntity()
	{
	}

	public VisitEntity(Visit visit)
	{
		this(visit.isSecondVisit(), visit.getVisitTime());
	}

	public VisitEntity(boolean secondVisit, Long visitTime)
	{
		this.secondVisit = secondVisit;
		this.visitTime = visitTime;
	}

	@Override
	@Column(name = "second_visit")
	public boolean isSecondVisit()
	{
		return secondVisit;
	}

	public void setSecondVisit(boolean secondVisit)
	{
		this.secondVisit = secondVisit;
	}

	@Column(name = "visit_time")
	public Long getVisitTime()
	{
		return visitTime;
	}

	public void setVisitTime(Long visitTime)
	{
		this.visitTime = visitTime;
	}
}
