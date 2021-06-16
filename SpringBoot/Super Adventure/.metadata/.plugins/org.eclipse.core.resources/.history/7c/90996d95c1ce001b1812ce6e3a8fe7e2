/**
 * 
 */
package engine;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 *	Class for all locations in Super Adventure
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Location
{
	private @Id int Id;
	private String Name;
	private String Description;
	
	private Item ItemRequiredToEnter;
	private Quest QuestAvailablehere;
	private Monster MonsterLivingHere;
	private Location LocationToNorth;
	private Location LocationToSouth;
	private Location LocationToEast;
	private Location LocationToWest;
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Location(int id, String name, String description)
	{
		Id = id;
		Name = name;
		Description = description;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param itemRequiredToEnter
	 */
	public Location(int id, String name, String description, Item itemRequiredToEnter)
	{
		super();
		Id = id;
		Name = name;
		Description = description;
		ItemRequiredToEnter = itemRequiredToEnter;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param questAvailablehere
	 */
	public Location(int id, String name, String description, Quest questAvailablehere)
	{
		super();
		Id = id;
		Name = name;
		Description = description;
		QuestAvailablehere = questAvailablehere;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param monsterLivingHere
	 */
	public Location(int id, String name, String description, Monster monsterLivingHere)
	{
		super();
		Id = id;
		Name = name;
		Description = description;
		MonsterLivingHere = monsterLivingHere;
	}		
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param itemRequiredToEnter
	 * @param questAvailablehere
	 * @param monsterLivingHere
	 */
	public Location(int id, String name, String description, Item itemRequiredToEnter, Quest questAvailablehere,
			Monster monsterLivingHere)
	{
		this(id, name, description);
		ItemRequiredToEnter = itemRequiredToEnter;
		QuestAvailablehere = questAvailablehere;
		MonsterLivingHere = monsterLivingHere;
	}
}