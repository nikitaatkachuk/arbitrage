package by.arbitrage.integration.piwik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created with IntelliJ IDEA.
 * User: nikita tkachuk
 * Date: 6/18/2015
 * Time: 6:43 AM
 */
public class PiwikResponseToObjectMapper
{
	public static PiwikDataResponseGenericObject responseToObject(String url)
	{
		PiwikDataResponseGenericObject result = new PiwikDataResponseGenericObject();
		URL destination = null;
		HttpURLConnection connection = null;
		try
		{
			destination = new URL(url);
			connection = (HttpURLConnection) destination.openConnection();
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(600);
			String s;
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())))
			{
				while((s = reader.readLine()) != null);
			}
			ObjectMapper mapper = new ObjectMapper() ;
			StringWriter writer = new StringWriter();
			writer.write(s);
			mapper.writeValue(writer, result);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace(); //todo: change me
		}
		catch (ProtocolException e)
		{
			e.printStackTrace(); //todo: change me
		}
		catch (IOException e)
		{
			e.printStackTrace(); //todo: change me
		}
		finally
		{
			if(connection != null)
			{
				connection.disconnect();
			}
		}
		return result;
	}
}
