package by.arbitrage.html;

import java.io.*;
import java.util.Map;

/**
 * Created by Nikita Tkachuk
 */
public final class ScriptGenerator
{
//	public static void main(String[] args)
//	{
//		generateScript("sadad");
//	}
	public static String generateScript(Map<String, Object> parameters)
	{
		//TODO
		StringBuilder builder = new StringBuilder();
		String guidMarker = "%GUID%";
		try(BufferedReader reader = new BufferedReader(new FileReader("E:\\ee\\springrest\\arbitrage\\src\\main\\resources\\genericScript.js"));)
		{
			while (reader.ready())
			{
				builder.append(reader.readLine());
			}
			//return builder.toString().replaceAll(guidMarker, siteGuid);
		}
		catch (IOException e)
		{
			//e.printStackTrace();
		}
		return "";
	}
}
