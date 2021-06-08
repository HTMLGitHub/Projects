/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class Location
{
	private int ID;
	private String Name;
	private String Description;
	
	private Item ItemRequiredToEnter;
	private Quest QuestAvailableHere;
	private Monster MonsterLivingHere;
	private Location LocationToNorth;
	private Location LocationToSouth;
	private Location LocationToEast;
	private Location LocationToWest;
	
	
	
	/**
	 * @param iD
	 * @param name
	 * @param description
	 */
	public Location(int iD, String name, String description)
	{
		ID = iD;
		Name = name;
		Description = description;
	}
	
	/**
	 * @param iD
	 * @param name
	 * @param description
	 * @param itemRequiredToEnter
	 * @param questAvailableHere
	 * @param monsterLivingHere
	 */
	public Location(int iD, String name, String description, Item itemRequiredToEnter, Quest questAvailableHere,
			Monster monsterLivingHere)
	{
		this(iD, name, description);
		ItemRequiredToEnter = itemRequiredToEnter;
		QuestAvailableHere = questAvailableHere;
		MonsterLivingHere = monsterLivingHere;
	}
	
	/**
	 * @return the itemRequiredToEnter
	 */
	public Item getItemRequiredToEnter()
	{
		return ItemRequiredToEnter;
	}
	/**
	 * @param itemRequiredToEnter the itemRequiredToEnter to set
	 */
	public void setItemRequiredToEnter(Item itemRequiredToEnter)
	{
		ItemRequiredToEnter = itemRequiredToEnter;
	}
	/**
	 * @return the questAvailableHere
	 */
	public Quest getQuestAvailableHere()
	{
		return QuestAvailableHere;
	}
	/**
	 * @param questAvailableHere the questAvailableHere to set
	 */
	public void setQuestAvailableHere(Quest questAvailableHere)
	{
		QuestAvailableHere = questAvailableHere;
	}
	/**
	 * @return the monsterLivingHere
	 */
	public Monster getMonsterLivingHere()
	{
		return MonsterLivingHere;
	}
	/**
	 * @param monsterLivingHere the monsterLivingHere to set
	 */
	public void setMonsterLivingHere(Monster monsterLivingHere)
	{
		MonsterLivingHere = monsterLivingHere;
	}
	/**
	 * @return the locationToNorth
	 */
	public Location getLocationToNorth()
	{
		return LocationToNorth;
	}
	/**
	 * @param locationToNorth the locationToNorth to set
	 */
	public void setLocationToNorth(Location locationToNorth)
	{
		LocationToNorth = locationToNorth;
	}
	/**
	 * @return the locationToSouth
	 */
	public Location getLocationToSouth()
	{
		return LocationToSouth;
	}
	/**
	 * @param locationToSouth the locationToSouth to set
	 */
	public void setLocationToSouth(Location locationToSouth)
	{
		LocationToSouth = locationToSouth;
	}
	/**
	 * @return the locationToEast
	 */
	public Location getLocationToEast()
	{
		return LocationToEast;
	}
	/**
	 * @param locationToEast the locationToEast to set
	 */
	public void setLocationToEast(Location locationToEast)
	{
		LocationToEast = locationToEast;
	}
	/**
	 * @return the locationToWest
	 */
	public Location getLocationToWest()
	{
		return LocationToWest;
	}
	/**
	 * @param locationToWest the locationToWest to set
	 */
	public void setLocationToWest(Location locationToWest)
	{
		LocationToWest = locationToWest;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ID;
		result = prime * result + ((ItemRequiredToEnter == null) ? 0 : ItemRequiredToEnter.hashCode());
		result = prime * result + ((LocationToEast == null) ? 0 : LocationToEast.hashCode());
		result = prime * result + ((LocationToNorth == null) ? 0 : LocationToNorth.hashCode());
		result = prime * result + ((LocationToSouth == null) ? 0 : LocationToSouth.hashCode());
		result = prime * result + ((LocationToWest == null) ? 0 : LocationToWest.hashCode());
		result = prime * result + ((MonsterLivingHere == null) ? 0 : MonsterLivingHere.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((QuestAvailableHere == null) ? 0 : QuestAvailableHere.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof Location)) return false;
		Location other = (Location) obj;
		if (Description == null)
		{
			if (other.Description != null) return false;
		}
		else
			if (!Description.equals(other.Description)) return false;
		if (ID != other.ID) return false;
		if (ItemRequiredToEnter == null)
		{
			if (other.ItemRequiredToEnter != null) return false;
		}
		else
			if (!ItemRequiredToEnter.equals(other.ItemRequiredToEnter)) return false;
		if (LocationToEast == null)
		{
			if (other.LocationToEast != null) return false;
		}
		else
			if (!LocationToEast.equals(other.LocationToEast)) return false;
		if (LocationToNorth == null)
		{
			if (other.LocationToNorth != null) return false;
		}
		else
			if (!LocationToNorth.equals(other.LocationToNorth)) return false;
		if (LocationToSouth == null)
		{
			if (other.LocationToSouth != null) return false;
		}
		else
			if (!LocationToSouth.equals(other.LocationToSouth)) return false;
		if (LocationToWest == null)
		{
			if (other.LocationToWest != null) return false;
		}
		else
			if (!LocationToWest.equals(other.LocationToWest)) return false;
		if (MonsterLivingHere == null)
		{
			if (other.MonsterLivingHere != null) return false;
		}
		else
			if (!MonsterLivingHere.equals(other.MonsterLivingHere)) return false;
		if (Name == null)
		{
			if (other.Name != null) return false;
		}
		else
			if (!Name.equals(other.Name)) return false;
		if (QuestAvailableHere == null)
		{
			if (other.QuestAvailableHere != null) return false;
		}
		else
			if (!QuestAvailableHere.equals(other.QuestAvailableHere)) return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Location [ID=");
		builder.append(ID);
		builder.append(", Name=");
		builder.append(Name);
		builder.append(", Description=");
		builder.append(Description);
		builder.append(", ItemRequiredToEnter=");
		builder.append(ItemRequiredToEnter);
		builder.append(", QuestAvailableHere=");
		builder.append(QuestAvailableHere);
		builder.append(", MonsterLivingHere=");
		builder.append(MonsterLivingHere);
		builder.append(", LocationToNorth=");
		builder.append(LocationToNorth);
		builder.append(", LocationToSouth=");
		builder.append(LocationToSouth);
		builder.append(", LocationToEast=");
		builder.append(LocationToEast);
		builder.append(", LocationToWest=");
		builder.append(LocationToWest);
		builder.append("]");
		return builder.toString();
	}
		
}
