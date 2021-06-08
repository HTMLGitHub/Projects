package engine;

import java.util.ArrayList;
import java.util.List;

public class Player extends LivingCreature
{
	private int Gold;
	private int ExperiencePoints;
	private int Level;
	
	private List<InventoryItem> Inventory;
	private List<PlayerQuest> Quests;
	
	/**
	 * @param currentHitPoints
	 * @param maximumHitPoints
	 * @param gold
	 * @param experiencePoints
	 * @param level
	 */
	public Player(int currentHitPoints, int maximumHitPoints, int gold, int experiencePoints, int level)
	{
		super(currentHitPoints, maximumHitPoints);
		Gold = gold;
		ExperiencePoints = experiencePoints;
		Level = level;
		
		Inventory = new ArrayList<InventoryItem>();
		Quests = new ArrayList<PlayerQuest>();
	}
	
	
	
	/**
	 * @return the inventory
	 */
	public List<InventoryItem> getInventory()
	{
		return Inventory;
	}



	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(List<InventoryItem> inventory)
	{
		Inventory = inventory;
	}



	/**
	 * @return the quests
	 */
	public List<PlayerQuest> getQuests()
	{
		return Quests;
	}



	/**
	 * @param quests the quests to set
	 */
	public void setQuests(List<PlayerQuest> quests)
	{
		Quests = quests;
	}



	/**
	 * @return the gold
	 */
	public int getGold()
	{
		return Gold;
	}
	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold)
	{
		Gold = gold;
	}
	/**
	 * @return the experiencePoints
	 */
	public int getExperiencePoints()
	{
		return ExperiencePoints;
	}
	/**
	 * @param experiencePoints the experiencePoints to set
	 */
	public void setExperiencePoints(int experiencePoints)
	{
		ExperiencePoints = experiencePoints;
	}
	/**
	 * @return the level
	 */
	public int getLevel()
	{
		return Level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level)
	{
		Level = level;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ExperiencePoints;
		result = prime * result + Gold;
		result = prime * result + ((Inventory == null) ? 0 : Inventory.hashCode());
		result = prime * result + Level;
		result = prime * result + ((Quests == null) ? 0 : Quests.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof Player)) return false;
		Player other = (Player) obj;
		if (ExperiencePoints != other.ExperiencePoints) return false;
		if (Gold != other.Gold) return false;
		if (Inventory == null)
		{
			if (other.Inventory != null) return false;
		}
		else
			if (!Inventory.equals(other.Inventory)) return false;
		if (Level != other.Level) return false;
		if (Quests == null)
		{
			if (other.Quests != null) return false;
		}
		else
			if (!Quests.equals(other.Quests)) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Player [Gold=");
		builder.append(Gold);
		builder.append(", ExperiencePoints=");
		builder.append(ExperiencePoints);
		builder.append(", Level=");
		builder.append(Level);
		builder.append(", Inventory=");
		builder.append(Inventory);
		builder.append(", Quests=");
		builder.append(Quests);
		builder.append("]");
		return builder.toString();
	}
}
