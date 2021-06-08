package engine;

public class Quest
{
	private int ID;
	private String Name;
	private String Description;
	private int RewardExperiencePoints;
	private int RewardGold;
	
	private Item RewardItem;
	
	/**
	 * @return the rewardItem
	 */
	public Item getRewardItem()
	{
		return RewardItem;
	}
	/**
	 * @param rewardItem the rewardItem to set
	 */
	public void setRewardItem(Item rewardItem)
	{
		RewardItem = rewardItem;
	}
	/**
	 * @return the iD
	 */
	public int getID()
	{
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD)
	{
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		Name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		Description = description;
	}
	/**
	 * @return the rewardExperiencePoints
	 */
	public int getRewardExperiencePoints()
	{
		return RewardExperiencePoints;
	}
	/**
	 * @param rewardExperiencePoints the rewardExperiencePoints to set
	 */
	public void setRewardExperiencePoints(int rewardExperiencePoints)
	{
		RewardExperiencePoints = rewardExperiencePoints;
	}
	/**
	 * @return the rewardGold
	 */
	public int getRewardGold()
	{
		return RewardGold;
	}
	/**
	 * @param rewardGold the rewardGold to set
	 */
	public void setRewardGold(int rewardGold)
	{
		RewardGold = rewardGold;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + RewardExperiencePoints;
		result = prime * result + RewardGold;
		result = prime * result + ((RewardItem == null) ? 0 : RewardItem.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof Quest)) return false;
		Quest other = (Quest) obj;
		if (Description == null)
		{
			if (other.Description != null) return false;
		}
		else
			if (!Description.equals(other.Description)) return false;
		if (ID != other.ID) return false;
		if (Name == null)
		{
			if (other.Name != null) return false;
		}
		else
			if (!Name.equals(other.Name)) return false;
		if (RewardExperiencePoints != other.RewardExperiencePoints) return false;
		if (RewardGold != other.RewardGold) return false;
		if (RewardItem == null)
		{
			if (other.RewardItem != null) return false;
		}
		else
			if (!RewardItem.equals(other.RewardItem)) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Quest [ID=");
		builder.append(ID);
		builder.append(", Name=");
		builder.append(Name);
		builder.append(", Description=");
		builder.append(Description);
		builder.append(", RewardExperiencePoints=");
		builder.append(RewardExperiencePoints);
		builder.append(", RewardGold=");
		builder.append(RewardGold);
		builder.append(", RewardItem=");
		builder.append(RewardItem);
		builder.append("]");
		return builder.toString();
	}
	
}
