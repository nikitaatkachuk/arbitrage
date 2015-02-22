package by.arbitrage.dto;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
public class SitesDTO
{
	private List<SiteDTO> sites;

	public SitesDTO(List<SiteDTO> sites)
	{
		this.sites = sites;
	}

	public List<SiteDTO> getSites()
	{
		return sites;
	}

	public void setSites(List<SiteDTO> sites)
	{
		this.sites = sites;
	}
}
