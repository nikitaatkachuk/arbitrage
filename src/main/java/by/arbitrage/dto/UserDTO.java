package by.arbitrage.dto;

/**
 * Created by Nikita Tkachuk
 */
public class UserDTO
{
	private String userName;

	public UserDTO(String userName)
	{
		this.userName = userName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
