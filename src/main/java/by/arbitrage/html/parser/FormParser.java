package by.arbitrage.html.parser;

import by.arbitrage.html.UserSiteForm;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Tkachuk
 */
public class FormParser
{
	public static Collection<UserSiteForm> getSiteFormsByUrl(String url) throws IOException
	{
		Collection<UserSiteForm> result = new HashSet<>();
		Document document = Jsoup.connect(url).get();
		Elements elements = document.getElementsByTag("form");

		for(Element element : elements)
		{
			String id = element.id();
			Set<String> classes = element.classNames();
			result.add(new SimpleForm(id, classes));
		}
		return result;
	}

	private static class SimpleForm extends UserSiteForm
	{
		public SimpleForm(String id, Set<String> classes)
		{
			this.formId = id;
			this.formClasses = classes;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this == o) return true;
			if (!(o instanceof SimpleForm)) return false;

			SimpleForm that = (SimpleForm) o;

			if (!formClasses.equals(that.formClasses)) return false;
			if (!formId.equals(that.formId)) return false;

			return true;
		}

		@Override
		public int hashCode()
		{
			int result = formId.hashCode();
			result = 31 * result + formClasses.hashCode();
			return result;
		}
	}
}
