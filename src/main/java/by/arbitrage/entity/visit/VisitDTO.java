package by.arbitrage.entity.visit;

import by.arbitrage.entity.general.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
public class VisitDTO extends AbstractDTO implements Visit
{
	private boolean secondVisit;
	private Long visitTime;
	private String userGuid;

	public VisitDTO()
	{
	}

	public VisitDTO(Visit visit)
	{
		this(visit.isSecondVisit(), visit.getVisitTime());
	}

	public VisitDTO(boolean secondVisit, Long visitTime)
	{
		this.secondVisit = secondVisit;
		this.visitTime = visitTime;
	}

	@Override
	public boolean isSecondVisit()
	{
		return secondVisit;
	}

	public void setSecondVisit(boolean secondVisit)
	{
		this.secondVisit = secondVisit;
	}

	public Long getVisitTime()
	{
		return visitTime;
	}

	public void setVisitTime(Long visitTime)
	{
		this.visitTime = visitTime;
	}

	@Override
	public String getUserGuid()
	{
		return userGuid;
	}

	public void setUserGuid(String userGuid)
	{
		this.userGuid = userGuid;
	}
}
