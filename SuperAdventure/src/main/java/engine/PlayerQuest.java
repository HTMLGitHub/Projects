package engine;

public class PlayerQuest
{
	private Quest Details;
	private boolean IsCompleted;
	
	/**
	 * @param details
	 * @param isCompleted
	 */
	public PlayerQuest(Quest details)
	{
		Details = details;
		IsCompleted = false;
	}
	
	/**
	 * @return the details
	 */
	public Quest getDetails()
	{
		return Details;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Details == null) ? 0 : Details.hashCode());
		result = prime * result + (IsCompleted ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof PlayerQuest)) return false;
		PlayerQuest other = (PlayerQuest) obj;
		if (Details == null)
		{
			if (other.Details != null) return false;
		}
		else
			if (!Details.equals(other.Details)) return false;
		if (IsCompleted != other.IsCompleted) return false;
		return true;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(Quest details)
	{
		Details = details;
	}
	/**
	 * @return the isCompleted
	 */
	public boolean isIsCompleted()
	{
		return IsCompleted;
	}
	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setIsCompleted(boolean isCompleted)
	{
		IsCompleted = isCompleted;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerQuest [Details=");
		builder.append(Details);
		builder.append(", IsCompleted=");
		builder.append(IsCompleted);
		builder.append("]");
		return builder.toString();
	}
	
	
}
