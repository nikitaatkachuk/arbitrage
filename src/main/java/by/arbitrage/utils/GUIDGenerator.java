package by.arbitrage.utils;

import java.util.UUID;

/**
 * Created by Nikita Tkachuk
 */
public final class GUIDGenerator
{
	public static String GUIDByString(String s)
	{
		return String.valueOf(UUID.fromString(s));
	}

	public static String randomGUID()
	{
		return String.valueOf(UUID.randomUUID());
	}
}
