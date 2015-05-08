package by.arbitrage.entity.script;

import by.arbitrage.entity.GenericEntityImpl;

import javax.persistence.*;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "script")
public class Script extends GenericEntityImpl
{
	private static final String GENERIC_SCRIPT = "<script>\n" +
			"\tvar _paq = _paq || [];\n" +
			"\t_paq.push(['trackPageView']);\n" +
			"\t (function(){ var u=((\"https:\" == document.location.protocol) ? \"https://localhost:8080/resources/js/\" : \"http://localhost:8080/resources/js/\");\n" +
			"          var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0]; g.type='text/javascript'; g.defer=true; g.async=true; g.src=u+'anal.js';\n" +
			"    s.parentNode.insertBefore(g,s); })();\n" +
			"          //ga('send', 'pageview');\n" +
			"      </script>";


	@Column(name = "script")
	private String userScript;

	public Script(String userScript)
	{
		this.userScript = userScript;
	}

	public Script() {}

	public String getUserScript()
	{
		return userScript;
	}

	public void setUserScript(String userScript)
	{
		this.userScript = userScript;
	}
}
