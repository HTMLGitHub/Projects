/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class Monster extends LivingCreature
{
	private int ID;
	private String Name;
	private int MaximumDamage;
	private int RewardExperiencePoints;
	private int RewardGold;
	
	/**
	 * @param currentHitPoints
	 * @param maximumHitPoints
	 * @param iD
	 * @param name
	 * @param maximumDamage
	 * @param rewardExperiencePoints
	 * @param rewardGold
	 */
	public Monster(int currentHitPoints, int maximumHitPoints, int iD, String name, int maximumDamage,
			int rewardExperiencePoints, int rewardGold)
	{
		super(currentHitPoints, maximumHitPoints);
		ID = iD;
		Name = name;
		MaximumDamage = maximumDamage;
		RewardExperiencePoints = rewardExperiencePoints;
		RewardGold = rewardGold;
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
	 * @return the maximumDamage
	 */
	public int getMaximumDamage()
	{
		return MaximumDamage;
	}
	/**
	 * @param maximumDamage the maximumDamage to set
	 */
	public void setMaximumDamage(int maximumDamage)
	{
		MaximumDamage = maximumDamage;
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
		int result = super.hashCode();
		result = prime * result + ID;
		result = prime * result + MaximumDamage;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + RewardExperiencePoints;
		result = prime * result + RewardGold;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof Monster)) return false;
		Monster other = (Monster) obj;
		if (ID != other.ID) return false;
		if (MaximumDamage != other.MaximumDamage) return false;
		if (Name == null)
		{
			if (other.Name != null) return false;
		}
		else
			if (!Name.equals(other.Name)) return false;
		if (RewardExperiencePoints != other.RewardExperiencePoints) return false;
		if (RewardGold != other.RewardGold) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Monster [ID=");
		builder.append(ID);
		builder.append(", Name=");
		builder.append(Name);
		builder.append(", MaximumDamage=");
		builder.append(MaximumDamage);
		builder.append(", RewardExperiencePoints=");
		builder.append(RewardExperiencePoints);
		builder.append(", RewardGold=");
		builder.append(RewardGold);
		builder.append("]");
		return builder.toString();
	}

	
}
