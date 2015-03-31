package by.arbitrage.entity.script;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Nikita Tkachuk
 */
@Entity(name = "script")
public class Script
{
	@Id @GeneratedValue
	private Long id;

	@Column(name = "script")
	private String userScript;

	public Script(String userScript)
	{
		this.userScript = userScript;
	}

	public Script() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUserScript()
	{
		return userScript;
	}

	public void setUserScript(String userScript)
	{
		this.userScript = userScript;
	}
}
