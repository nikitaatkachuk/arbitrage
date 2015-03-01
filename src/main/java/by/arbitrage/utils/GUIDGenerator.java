package by.arbitrage.utils;

import java.util.UUID;

/**
 * Created by Nikita Tkachuk
 */
public final class GUIDGenerator
{
	public static String randomGUID()
	{
		return String.valueOf(UUID.randomUUID());
	}
}
