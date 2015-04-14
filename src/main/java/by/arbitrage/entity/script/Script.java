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
	private static final String GENERIC_SCRIPT = " <script>\n" +
			"          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
			"              (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
			"                  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
			"          })(window,document,'script','//localhost:8080/resources/js/anal.js','ga');\n" +
			"\n" +
			"          ga();\n" +
			"         // ga('send', 'pageview');\n" +
			"      </script>";

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
