package by.arbitrage.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Nikita Tkachuk
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewSiteDTO implements Serializable
{
	@JsonProperty("url")
	private String url;

	public NewSiteDTO()
	{
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
